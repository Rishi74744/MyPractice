package com.java.hackerrank.dynamic.programming;

import java.util.Scanner;

public class SuffixRotation {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int qItr = 0; qItr < q; qItr++) {
			String s = scanner.nextLine();
			String str[] = s.split("");
			int rot = 0;
			int index = 0;
			while ((index = checkIfStringIsLexicographicOrdered(str, index)) != -1) {
				// rot++;
				for (int i = index; i < str.length - 1; i++) {
					boolean isChanged = false;
					if (str[i].compareTo(str[i + 1]) > 0) {
						String temp = str[i];
						str[i] = str[i + 1];
						str[i + 1] = temp;
						isChanged = true;
					}
					if (isChanged) {
						rot++;
					}
				}
			}
			System.out.println(rot);
		}

		scanner.close();
	}

	public static int checkIfStringIsLexicographicOrdered(String[] str, int index) {
		// System.out.println(index);
		for (int i = index; i < str.length - 1; i++) {
			if (str[i].compareTo(str[i + 1]) > 0) {
				System.out.println(str[i] + " : " + i);
				return i;
			}
		}
		return -1;
	}
}

/*
 * 100
 * aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
 * abcdefghijklmnopqrstuvwxyz
 * lcatqjejhpgkrkhnxsfyqlulncefeytykwnqbfmqaduldwhgwruwkdvojexefcmfrlfuzzcurjgnnbkskbzw
 * suvqstsbycwecvlzmpccdbzr wxxezdpirhjkgiooxcuuagrxwxea
 * wmrqafieovprruqryktatgcfmtwuacevcfwdbtmpnftpjtywhfodbepmqytbcfiuruekavgasbkxisffigjfdcrmnwwbab
 * nurbulujavtmngzdcqijwnajsztktucrjgnnkkcsljkwuldyewfitmrkjznmsicltelowsixfuhmni
 * sdpdknlmqmdgpwodm ozzcegnbscokkatcszflzsuqauortbgbtbamcdtmztnehthpfwbwz
 * brnykhovqcdrmsdohwelwaeivqqyksroadjsjggmexrgwtv
 * elnnqmxrqdyjesodmpkntwjfoynxzodosnhosykovnlpiukjpcpzdwjjegtwfgvylwpvjpp
 * xzdsurrykhzhundal srxbvay hevehsirrvfqjazywdrseiuvmqqepqimfi jxofqjjepvgmh
 * cekqtuzvjxccapjdxafmkwuvtzkyf
 * rwbvidydsxmogjumrkoavbboyplfghvpjxpzxcmjedjuaqribbvgbanxyemvkhciqigmrkhsqaykvapzuxppmnjldwbl
 * gwoarpimjvxawpzdfmukkvwczxhdpecwxbhpkxabnxpktoczrfjywilvsitatxsbnfrhifonfwjcz
 * thejbkxmruacvychwzfupzajhbqpugdvmkaxamygqgietvdqiviyyibylutrsihdppwnsqzwojrnutqc
 * pqaveucwrqjxoxnzukvyjbswtyjjccnigzdkoswllctmimhokoerdvgzfej
 * icbpglcyaqjnfhnicwugjlbsdhzughbngqbhmrtswlonkdldjumbogxkucgasacpxzqderqpzphv
 * lutiiiutwaq drszwbpjoenfspvdlxg
 * uzxuiwaxceykqxkreolyshyutuvgmyyehroslagdfylgcmamntwxucdtcrb
 * irppqfxnubutsaipxkxtvpztruqusceqcqfngxivjutxksytyozjjwwkwsrameldqckdantkchzsogxar
 * wxshklbucwfrzvpsqhfkbmntwwwxjrmsbxdzknyxfgt
 * yflfyrtpmzeoikssdqyatonfvqzezejxkhurlxyttvdzqpccrmxxjlrowetbegbolt o
 * zedyokddxgkydmulskrpjswtseoxwtzntn
 * bcycmhzxavnanmxilsnvtotwnnsbhinqbutqmbjblkbididtjq
 * exuwqqjfkqiwhceppgyicjcmvtqwhuuzhhjuywnayhkdgtgbcqzovxoyycazhofrbsgbvyuarhnivxkjgstvvcv
 * jzcsll stevjc
 * zfgdwheibmzhxjapvtpxysitasszvfltmbweubltyqledyoyttlhrfspboavykencfagdgjiiqaixjumdgvgmivbqbppbolna
 * xkebrdhjmwagmjubhdmipsqoupeayucj
 * vcfgyxmgnhzzfddcmywqvkkvxvidxscmqfsszitmudosaerdkenkqwpjsrclozfdrgyrmgfmictredxukcljrppewgedfbmpdpl
 * lanfcrerhowzipnfdfennphivolkqbrimmltwqokkcpzfvzrmcbkinklapioerhtqartuinyoexlyjy
 * paopikshkbvodujaepxmhtixvrkzkfshutlezebgsbmxwrhtfkoxisirceibfvouygvgozdcsifhrpofxprv
 * tflltktswggbfysygprcqbxqdueeymmuwbhuixoljgdkekkfxicmrxwusngdgmsoejairgpgoxavnyqxdbzfxjhchyaaob
 * fwpwdfvsdcoijtnprxeadpkrofjfroohspdcnjmzlvtzi
 * yefqjxlbcoikbjvycamvjqgntbiuaozuxgqpjpchqcemkjcutlyyqddzjcwmdechqixlwdttapmiktiheuzgrvnddprnugpot
 * fbegsjgskqvdrswbhlbjtrejyqghdqcucpvuegardnzmwgqbyetlbahitwbnoxvysapwhtoywvodlz
 * bcelqsmxmzdxofnvkkmbgauzbhvwyxualuzxctnf
 * ciheodjxgmsairgwccqlfbdnhieaglbwcklkdvbw
 * iuuqzlcisuczqnvqlnidpuvflcvvjyfdjirxothvtrdvwbfnwnxrleuftoxphfbyvqghmhabvsqewyazultp
 * xsyhgygvvxcwhajc zexkromxujdtkjzpcwnppsuieqldysblm hdhtyulqafddqtyyycpewbld
 * lxnndstspflrainiobrnwcgsfloygfemtxdcglhhrdyyknhtsrnqznlveddgykcjoaknwtqpjwhxbeqorhlolncfgxlbtjmhuz
 * vxbgpkmaltfcottlwjadswjxlotkdvm
 * baktuuwefikuqldspshizdtdourthndctvnvukosngajwgisjfrkybsblmafpyndehrpfhcylijffcwj
 * opjoj ukdbdbdzabvvtuffncdyisdglhbwbvjqtpdijwpheoztwetolzzltcngmhalcslxfo
 * ogjdufoqhduijuibmtkpwvudviinfkcvdgyungnkhusaofijqkompstzxpri
 * ipcxxhimtvvdtqypsvhjacbdhgngocjdbjqqoikwtolobgprwlkdwknuxbl
 * ferejlhubhglwbuqpimacmhsoklcsrlbcwuxwwgzvqtltyvyinvtntqoiytjtnqkukljrybnlzyagkurkegsg
 * lqvmmqybpqutjflfyuwbzygkuuxldkgyjumgosogrwxzydsazzaaybfzuhzq
 * smnxhrcxsnagzwijhjuldbebzpmqspmuycarpjhnssfa xcoxfvxyyfzhovejxzciofedgbjfdyz
 * ssffqoxqyfzlkvetghpywiolcjhfygsbwpdzrslntwuoiefznpfxspnqcdzacdznoyhydexvcaywopvumof
 * aqvkghwdvkttrxxewxfpuz tkldpnosijqgvkrtixxcvkoemfrcefjay
 * swgzjwoipbwkgcigmmfjjjmvqczddkuepvxikeh tfxtgirephcwaadjuizbhsrw
 * ffymhkalqcfiyvsoikuhkgnlbknszpvoyzkwg efxfszpmopookcngveuoh
 * ktwqmjnfjllmppbzmkrsdwjxrofdfrailubryxrxxzehbvrur
 * vkvhadkppenqidgvimivihxemkiasujk
 * bzbqazytkkcealaulrzmzaddyqpqbxbolurtlotxvpajszsaxovsvnrppzhfnegilkuyjtqtzwysykrubvzaqdqhijfobyqlp
 * zcelnjrwxxxtjntkoezfegskqasczktconnsgvfndzcrqnkdwyuwsv
 * bhygcjfdunxblsjdwctuvtuxyuahfiqadrwf
 * ujxkytxzytmbvhviojgxsijvwjxvdjayqjqkimvkovupnqfpzlyrtjv
 * oyyfntoecraarcapdwuinohkeeiiwlodhmvodzjnnqtajcpqhitih
 * xqavzvrgmalbwalkhpwrcwnwmsngfqnnzomelqoahxivgcyxniixyegrqawuyrw
 * wtzczrotnxcmyljpaprbwagwdmkdgtunnwzdyqjb hjtvze
 * ktzmgnmjctxesucyomedgyihlvpsdbxeiyhebuvwxjxtnokwafiuwjafygywgzayptabvzzsnodmyhdnbdrcqsiqrepkvrwttj
 * o qboqadcsnoeoshxdqvbwnlvykjcozulmvxacrznpevarjapebpkwyqjparijuicprslqrictb
 * aczuttrrukllfmzikfgzqcqqcugvpjaobunhdlskabqfkozmqottsrcrjucbcsnnjihxzqeh
 * aclsuiqccfkwevcyljtjrauynobwxlxtxarquif
 * skbshokfivooodaqllshsdpxalvnahigidagbmir psdndeiu
 * kgpqtbllnpukvjzizdkkyybnmigaxlofktafvjetcaayoacjlv abllnm
 * hzifloczkwduxsepteqjbwozkuypdmhoikyezyxzqtmdtpjyndhqinbgushktsqxuuyfyshbh
 * yxrnmjgnxuqyhfoedztbc
 * ixtmdjbycgjwgujsjfdfvtkxdivrwnrkwfaazzbcezdtnnslqguhfhlxbhyebhcnvrnqftvvdmlvvrcmtwksawtk
 * zfeqvoqulaadhfxikozzbufyyiadmapwvprkjwhxijuoohghzntcrut
 * vuzxhjawpccawuswprfeez
 * yvjzccqnikxsrrqplmltibasfufhzdgwnnpzdrnzeuitaupkdspviuxvrnfzdhdnuigda
 * gsaegkvqji
 * seobtyxihvmbncxixystogimgqwxpujsqvjdoylkutwwjysbvmxzxyboqtbtqyarayagxdiylylewvlrmqcruilzujjahmgchmv
 * ieukttrzwkbekgmfabgcohkvbfgexhmxymbqfzabqqfivfzciaufvkbawcexeqevzhdaqmcfsdywrr
 * petbedvdsvnjijbeumafagziwlqcfidaqnyazoek emsnomnlwmuotxeqgxhiysamhxxomxkhlk
 * gwighdwculchadyathwqptqlyqcjgoqgu wndjnfpybmtguguzsrbwoycxjwakprqnfzbly
 * kvdsjeqtg bljgrptiswjojvlouavpctrcwmnnqwsyijzorkxgavnqbcb
 */
