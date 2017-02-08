package com.algorithms;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Vector;

public class BellMenFord {

	/**
	 * @param args
	 */
	static int n;
	static int m;
	static double d[];
	static Vector<Integer> tree[];
	static boolean reachable[];

	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		OutputWriter out = new OutputWriter(System.out);
		int t = in.readInt();
		DecimalFormat df = new DecimalFormat("0.00000000");
		while (t > 0) {
			n = in.readInt();
			m = in.readInt();
			tree = new Vector[n + 1];
			reachable = new boolean[n + 1];
			d = new double[n + 1];
			node2 edge[] = new node2[m + 1];
			for (int i = 0; i <= m; i++)
				edge[i] = new node2();
			for (int i = 0; i <= n; i++)
				tree[i] = new Vector<Integer>();

			for (int i = 1; i <= m; i++) {
				int u = in.readInt();
				int v = in.readInt();
				int w = in.readInt();
				edge[i].u = u;
				edge[i].v = v;

				edge[i].w = w;
				tree[u].add(v);
			}

			int u = in.readInt();
			int v = in.readInt();
			boolean b = dfs(u, v);
			if (b == false) {
				out.printLine(-1);
			}

			else {

				double a1 = -100;
				double b1 = 100;

				while (b1 - a1 > .000000001) {
					Arrays.fill(d, Long.MAX_VALUE);
					d[u] = 0;
					double l = (b1 + a1) / 2;

					for (int i = 1; i <= n - 1; i++) {
						for (int j = 1; j <= m; j++) {
							int v1 = edge[j].v;
							int u1 = edge[j].u;
							double w = edge[j].w - l;
							// out.printLine(w);
							// out.printLine(v1);
							// out.printLine(u1);
							if (d[v1] > d[u1] + w) {
								d[v1] = d[u1] + w;
								// out.printLine(u1+" "+v1);
							}
						}
					}
					boolean isneg = false;
					for (int j = 1; j <= m; j++) {
						int v1 = edge[j].v;
						int u1 = edge[j].u;
						double w = edge[j].w - l;
						reachable = new boolean[n + 1];
						if ((d[v1] > d[u1] + w) && (dfs(u, v1))) {
							reachable = new boolean[n + 1];
							if (dfs(v1, v))
								isneg = true;
						}
					}

					if (isneg == true || d[v] <= 0) {
						b1 = l;
					} else {
						a1 = l;
					}

				}
				out.printLine(df.format((a1 + b1) / 2));
			}
			t--;
		}
		out.close();
	}

	static boolean dfs(int source, int des) {

		if (reachable[source] == true) {
			return false;
		}
		reachable[source] = true;
		if (des == source) {
			return true;
		}

		for (int x : tree[source]) {
			if (reachable[x] == false) {
				boolean b = dfs(x, des);
				if (b == true)
					return true;
			}
		}
		return false;

	}
}

class node2 {
	int u;
	int v;
	int w;
}

class InputReader {

	private InputStream stream;
	private byte[] buf = new byte[1024];
	private int curChar;
	private int numChars;
	private SpaceCharFilter filter;

	public InputReader(InputStream stream) {
		this.stream = stream;
	}

	public int read() {
		if (numChars == -1)
			throw new InputMismatchException();
		if (curChar >= numChars) {
			curChar = 0;
			try {
				numChars = stream.read(buf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (numChars <= 0)
				return -1;
		}
		return buf[curChar++];
	}

	public int readInt() {
		int c = read();
		while (isSpaceChar(c))
			c = read();
		int sgn = 1;
		if (c == '-') {
			sgn = -1;
			c = read();
		}
		int res = 0;
		do {
			if (c < '0' || c > '9')
				throw new InputMismatchException();
			res *= 10;
			res += c - '0';
			c = read();
		} while (!isSpaceChar(c));
		return res * sgn;
	}

	public String readString() {
		int c = read();
		while (isSpaceChar(c))
			c = read();
		StringBuilder res = new StringBuilder();
		do {
			res.appendCodePoint(c);
			c = read();
		} while (!isSpaceChar(c));
		return res.toString();
	}

	public boolean isSpaceChar(int c) {
		if (filter != null)
			return filter.isSpaceChar(c);
		return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
	}

	public String next() {
		return readString();
	}

	public interface SpaceCharFilter {
		public boolean isSpaceChar(int ch);
	}
}

class OutputWriter {
	private final PrintWriter writer;

	public OutputWriter(OutputStream outputStream) {
		writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
				outputStream)));
	}

	public OutputWriter(Writer writer) {
		this.writer = new PrintWriter(writer);
	}

	public void print(Object... objects) {
		for (int i = 0; i < objects.length; i++) {
			if (i != 0)
				writer.print(' ');
			writer.print(objects[i]);
		}
	}

	public void printLine(Object... objects) {
		print(objects);
		writer.println();
	}

	public void close() {
		writer.close();
	}

	public void flush() {
		writer.flush();
	}

}

class IOUtils {

	public static int[] readIntArray(InputReader in, int size) {
		int[] array = new int[size];
		for (int i = 0; i < size; i++)
			array[i] = in.readInt();
		return array;
	}

}
