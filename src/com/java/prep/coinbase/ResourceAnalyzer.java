package com.java.prep.coinbase;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Write a function that takes the logs as input, builds the transition graph
 * and returns it as an adjacency list with probabilities. Add START and END
 * states. Specifically, for each resource, we want to compute a list of every
 * possible next step taken by any user, together with the corresponding
 * probabilities. The list of resources should include START but not END, since
 * by definition END is a terminal state.
 * 
 * 
 * logs1 = [ ["58523", "user_1", "resource_1"},{"62314", "user_2",
 * "resource_2"},{"54001", "user_1", "resource_3"},{"200", "user_6",
 * "resource_5"},{"215", "user_6", "resource_4"},{"54060", "user_2",
 * "resource_3"},{"53760", "user_3", "resource_3"},{"58522", "user_22",
 * "resource_1"},{"53651", "user_5", "resource_3"},{"2", "user_6",
 * "resource_1"},{"100", "user_6", "resource_6"},{"400", "user_7",
 * "resource_2"},{"100", "user_8", "resource_6"},{ "54359", "user_1",
 * "resource_3"], ]
 * 
 * Expected output for logs1:
 * 
 * transition_graph(logs1) # => { 'START': {'resource_1': 0.25, 'resource_2':
 * 0.125, 'resource_3': 0.5, 'resource_6': 0.125}, 'resource_1': {'resource_6':
 * 0.333, 'END': 0.667}, 'resource_2': {'END': 1.0}, 'resource_3': {'END': 0.4,
 * 'resource_1': 0.2, 'resource_2': 0.2, 'resource_3': 0.2}, 'resource_4':
 * {'END': 1.0}, 'resource_5': {'resource_4': 1.0}, 'resource_6': {'END': 0.5,
 * 'resource_5': 0.5} }
 * 
 * Explanation :
 * 
 * For example, of 8 total users, 4 users have resource_3 as a first visit
 * (user_1, user_2, user_3, user_5), 2 users have resource_1 as a first visit
 * (user_6, user_22), 1 user has resource_2 as a first visit (user_7), and 1
 * user has resource_6 (user_8) so the possible next steps for START are
 * resource_3 with probability 4/8, resource_1 with probability 2/8, and
 * resource_2 and resource_6 with probability 1/8. These are the resource paths
 * per user for the first logs example, ordered by access time:
 * 
 * { 'user_1': ['resource_3', 'resource_3', 'resource_1'], 'user_2':
 * ['resource_3', 'resource_2'], 'user_3': ['resource_3'], 'user_5':
 * ['resource_3'], 'user_6': ['resource_1', 'resource_6', 'resource_5',
 * 'resource_4'], 'user_7': ['resource_2'], 'user_8': ['resource_6'], 'user_22':
 * ['resource_1'], }
 * 
 * 
 * Expected output for logs2: transition_graph(logs2) # => { 'START':
 * {'resource_3': 1.0}, 'resource_3': {'resource_3: 0.857, 'END': 0.143} }
 * 
 * 
 * Expected output for logs3: transition_graph(logs3) # => { 'START':
 * {'resource_5': 1.0}, 'resource_5': {'END': 1.0} }
 */
public class ResourceAnalyzer {

	private Map<String, Set<Resource>> userResourceMapByAccessOrder = new HashMap<>();
	private Map<String, List<String>> resourceDependency = new HashMap<>();
	private Set<String> resources = new HashSet<>();
	DecimalFormat decimalFormat = new DecimalFormat("#.###");

	public Map<String, Map<String, Double>> findResourceProbability(String[][] logs) {
		Map<String, Map<String, Double>> result = new HashMap<>();
		decimalFormat.setRoundingMode(RoundingMode.HALF_DOWN);
		createUserResourceAccessMap(logs);
		double totalUsers = userResourceMapByAccessOrder.size();
		Map<String, Integer> resourceCount = calculateResourceCount();
		Map<String, Double> resourceProbability = calculateResourceStartProbability(totalUsers, resourceCount);
		Map<String, Map<String, Double>> nextResourceProbability = calculateNextResourceProbability();
		result.put("START", resourceProbability);
		result.putAll(nextResourceProbability);
		return result;
	}

	private Map<String, Map<String, Double>> calculateNextResourceProbability() {
		Map<String, Map<String, Double>> nextResourceProbability = new HashMap<>();
		for (Map.Entry<String, List<String>> e : resourceDependency.entrySet()) {
			Map<String, Double> resourcesProb = new HashMap<>();
			List<String> dependentResources = e.getValue();
			Map<String, Integer> dependentResourceCount = new HashMap<>();
			double total = (double) dependentResources.size();
			for (String res : dependentResources) {
				dependentResourceCount.put(res, dependentResourceCount.getOrDefault(res, 0) + 1);
			}
			for (Map.Entry<String, Integer> e1 : dependentResourceCount.entrySet()) {
				String key = e1.getKey();
				if (key == null) {
					key = "END";
				}
				double probability = Double.parseDouble(decimalFormat.format(e1.getValue() / total));
				resourcesProb.put(key, probability);
			}
			nextResourceProbability.put(e.getKey(), resourcesProb);
		}
		return nextResourceProbability;
	}

	private Map<String, Integer> calculateResourceCount() {
		Map<String, Integer> resourceCount = new HashMap<>();
		for (Map.Entry<String, Set<Resource>> e : userResourceMapByAccessOrder.entrySet()) {
			String firstResource = e.getValue().iterator().next().getResourceId();
			resourceCount.put(firstResource, resourceCount.getOrDefault(firstResource, 0) + 1);
			Set<Resource> userResources = e.getValue();
			if (userResources.size() == 1) {
				addResourceDependency(firstResource, null);
			} else {
				String previousResource = null;
				for (Resource resource : userResources) {
					if (previousResource != null) {
						addResourceDependency(previousResource, resource.getResourceId());
					}
					previousResource = resource.getResourceId();
				}
				addResourceDependency(previousResource, null);
			}
		}
		System.out.println(resourceDependency);
		return resourceCount;
	}

	private void addResourceDependency(String firstResource, String dependentResource) {
		List<String> dependencyList = resourceDependency.getOrDefault(firstResource, new ArrayList<>());
		dependencyList.add(dependentResource);
		resourceDependency.put(firstResource, dependencyList);
	}

	private Map<String, Double> calculateResourceStartProbability(double totalUsers,
			Map<String, Integer> resourceCount) {
		Map<String, Double> resourceProbability = new HashMap<>();
		for (Map.Entry<String, Integer> e : resourceCount.entrySet()) {
			double probability = Double.parseDouble(decimalFormat.format(e.getValue() / totalUsers));
			resourceProbability.put(e.getKey(), probability);
		}
//		addRemainingResourcesWithZeroProbability(resourceProbability);
		return resourceProbability;
	}

	private void addRemainingResourcesWithZeroProbability(Map<String, Double> resourceProbability) {
		for (String resource : resources) {
			if (!resourceProbability.containsKey(resource)) {
				resourceProbability.put(resource, 0.0);
			}
		}
	}

	private void createUserResourceAccessMap(String[][] logs) {
		for (String log[] : logs) {
			Resource resource = parseLog(log);
			Set<Resource> accessedResources = userResourceMapByAccessOrder.getOrDefault(resource.getUserId(),
					new TreeSet<Resource>(new Comparator<Resource>() {
						@Override
						public int compare(Resource o1, Resource o2) {
							return o1.getTimeStamp().compareTo(o2.getTimeStamp());
						}
					}));
			accessedResources.add(resource);
			resources.add(resource.getResourceId());
			userResourceMapByAccessOrder.put(resource.getUserId(), accessedResources);
		}
	}

	private Resource parseLog(String log[]) {
		return new Resource(Integer.parseInt(log[0]), log[1], log[2]);
	}

	public static void main(String[] args) {
		ResourceAnalyzer r = new ResourceAnalyzer();
		String[][] logs = { { "58523", "user_1", "resource_1" }, { "62314", "user_2", "resource_2" },
				{ "54001", "user_1", "resource_3" }, { "200", "user_6", "resource_5" },
				{ "215", "user_6", "resource_4" }, { "54060", "user_2", "resource_3" },
				{ "53760", "user_3", "resource_3" }, { "58522", "user_22", "resource_1" },
				{ "53651", "user_5", "resource_3" }, { "2", "user_6", "resource_1" }, { "100", "user_6", "resource_6" },
				{ "400", "user_7", "resource_2" }, { "100", "user_8", "resource_6" },
				{ "54359", "user_1", "resource_3" }, };
		System.out.println(r.findResourceProbability(logs));
	}

}

class Resource {
	private Integer timeStamp;
	private String userId;
	private String resourceId;

	public Resource(Integer timeStamp, String userId, String resourceId) {
		this.timeStamp = timeStamp;
		this.userId = userId;
		this.resourceId = resourceId;
	}

	public Integer getTimeStamp() {
		return timeStamp;
	}

	public String getUserId() {
		return userId;
	}

	public String getResourceId() {
		return resourceId;
	}

	@Override
	public String toString() {
		return "Resource [timeStamp=" + timeStamp + ", userId=" + userId + ", resourceId=" + resourceId + "]";
	}

}
