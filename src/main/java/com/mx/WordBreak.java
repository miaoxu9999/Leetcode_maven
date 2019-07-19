package com.mx;

import java.util.*;

/**
 * @ClassName WordBreak
 * @Description TODO
 * @Author miaoxu
 * @Date 2019/4/25 17:12
 * @Version 1.0
 **/
public class WordBreak {
    int[][] memo;
    int[] m;
//    public boolean wordBreak(String s, List<String> wordDict) {
//        Set<String> set = new HashSet<>(wordDict);
////         memo= new int[s.length()][s.length()];
//         boolean[] dp = new boolean[s.length() + 1];
//         boolean[] m = new boolean[s.length() + 1];
////        int t = dp(0, s.length() - 1, set, s);
//        dp[0] = true;
//        for (int i = 1; i <= s.length(); i++) {
//            for (int j = 0; j < i ; j++) {
//                String t = s.substring(j, i);
//                if (dp[j] && set.contains(t))
//                {
//                    dp[i] = true;
//                    break;
//                }
//            }
//        }
//
//        return dp[s.length()];
//    }

        public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        memo = new int[s.length()][s.length()];
         int t = dp(0, s.length() - 1, set, s);
        return t == 2;
    }

//    public boolean wordBreak(String s, List<String> wordDict) {
//        Set<String> set = new HashSet<>(wordDict);
//         m = new int[s.length()];
//        int res = dp(0, set, s);
//
//
//        return res == 2;
//    }

    // [start, end]中的字符串是否是set中的子串， 以及[end + 1, s.len -1] 是否为set中的子串
    public int  dp(int start, int end, Set<String> set, String s)
    {
        if (start > end)
        {
            return 1;
        }
        if (memo[start][end] != 0)
        {
            return memo[start][end];
        }
        String left = s.substring(start, end + 1);
        if (left.equals(""))
        {
            return 2;
        }
        if (set.contains(left))
        {
            memo[start][end] = 2;
            return 2;
        }
        if (left.length() == 1)
        {
            memo[start][end] = 1;
            return 1 ;
        }
        for (int i = start; i < end; i++)
        {
            if (memo[start][i] == 2 && memo[i + 1][end] == 2)
            {
                memo[start][end] = 2;
                return 2;
            }
            int t1 = dp(start, i, set, s);
            if (t1 != 2)
            {
                continue;
            }
            int t2 = dp(i + 1, end, set, s);
            if (t2 == 2)
            {
                memo[start][end] = 2;
                return 2;
            }
        }
        memo[start][end] = 1;
        return 1;

    }

    //从[index...s.len - 1]是否能分割
    public int  dp(int index, Set<String> set, String s)
    {
        if (index >= s.length())
        {
            return 1;
        }
        if (m[index] != 0)
        {
            return m[index];
        }
        if ( set.contains(s.substring(index, s.length())))
        {
            m[index] = 2;
            return 2;
        }
        for (int i = 0; i + index< s.length(); i++)
        {
            String string = s.substring(index, index + i + 1);
            if (set.contains(string) && dp(index + i + 1, set, s) == 2)
            {
                m[index] = 2;
                return 2;
            }
        }
        m[index] = 1;
        return 1;
    }

    public static void main(String[] args) {
//        String[] wordDict = {"kfomka","hecagbngambii","anobmnikj","c","nnkmfelneemfgcl","ah","bgomgohl","lcbjbg","ebjfoiddndih","hjknoamjbfhckb","eioldlijmmla","nbekmcnakif","fgahmihodolmhbi","gnjfe","hk","b","jbfgm","ecojceoaejkkoed","cemodhmbcmgl","j","gdcnjj","kolaijoicbc","liibjjcini","lmbenj","eklingemgdjncaa","m","hkh","fblb","fk","nnfkfanaga","eldjml","iejn","gbmjfdooeeko","jafogijka","ngnfggojmhclkjd","bfagnfclg","imkeobcdidiifbm","ogeo","gicjog","cjnibenelm","ogoloc","edciifkaff","kbeeg","nebn","jdd","aeojhclmdn","dilbhl","dkk","bgmck","ohgkefkadonafg","labem","fheoglj","gkcanacfjfhogjc","eglkcddd","lelelihakeh","hhjijfiodfi","enehbibnhfjd","gkm","ggj","ag","hhhjogk","lllicdhihn","goakjjnk","lhbn","fhheedadamlnedh","bin","cl","ggjljjjf","fdcdaobhlhgj","nijlf","i","gaemagobjfc","dg","g","jhlelodgeekj","hcimohlni","fdoiohikhacgb","k","doiaigclm","bdfaoncbhfkdbjd","f","jaikbciac","cjgadmfoodmba","molokllh","gfkngeebnggo","lahd","n","ehfngoc","lejfcee","kofhmoh","cgda","de","kljnicikjeh","edomdbibhif","jehdkgmmofihdi","hifcjkloebel","gcghgbemjege","kobhhefbbb","aaikgaolhllhlm","akg","kmmikgkhnn","dnamfhaf","mjhj","ifadcgmgjaa","acnjehgkflgkd","bjj","maihjn","ojakklhl","ign","jhd","kndkhbebgh","amljjfeahcdlfdg","fnboolobch","gcclgcoaojc","kfokbbkllmcd","fec","dljma","noa","cfjie","fohhemkka","bfaldajf","nbk","kmbnjoalnhki","ccieabbnlhbjmj","nmacelialookal","hdlefnbmgklo","bfbblofk","doohocnadd","klmed","e","hkkcmbljlojkghm","jjiadlgf","ogadjhambjikce","bglghjndlk","gackokkbhj","oofohdogb","leiolllnjj","edekdnibja","gjhglilocif","ccfnfjalchc","gl","ihee","cfgccdmecem","mdmcdgjelhgk","laboglchdhbk","ajmiim","cebhalkngloae","hgohednmkahdi","ddiecjnkmgbbei","ajaengmcdlbk","kgg","ndchkjdn","heklaamafiomea","ehg","imelcifnhkae","hcgadilb","elndjcodnhcc","nkjd","gjnfkogkjeobo","eolega","lm","jddfkfbbbhia","cddmfeckheeo","bfnmaalmjdb","fbcg","ko","mojfj","kk","bbljjnnikdhg","l","calbc","mkekn","ejlhdk","hkebdiebecf","emhelbbda","mlba","ckjmih","odfacclfl","lgfjjbgookmnoe","begnkogf","gakojeblk","bfflcmdko","cfdclljcg","ho","fo","acmi","oemknmffgcio","mlkhk","kfhkndmdojhidg","ckfcibmnikn","dgoecamdliaeeoa","ocealkbbec","kbmmihb","ncikad","hi","nccjbnldneijc","hgiccigeehmdl","dlfmjhmioa","kmff","gfhkd","okiamg","ekdbamm","fc","neg","cfmo","ccgahikbbl","khhoc","elbg","cbghbacjbfm","jkagbmfgemjfg","ijceidhhajmja","imibemhdg","ja","idkfd","ndogdkjjkf","fhic","ooajkki","fdnjhh","ba","jdlnidngkfffbmi","jddjfnnjoidcnm","kghljjikbacd","idllbbn","d","mgkajbnjedeiee","fbllleanknmoomb","lom","kofjmmjm","mcdlbglonin","gcnboanh","fggii","fdkbmic","bbiln","cdjcjhonjgiagkb","kooenbeoongcle","cecnlfbaanckdkj","fejlmog","fanekdneoaammb","maojbcegdamn","bcmanmjdeabdo","amloj","adgoej","jh","fhf","cogdljlgek","o","joeiajlioggj","oncal","lbgg","elainnbffk","hbdi","femcanllndoh","ke","hmib","nagfahhljh","ibifdlfeechcbal","knec","oegfcghlgalcnno","abiefmjldmln","mlfglgni","jkofhjeb","ifjbneblfldjel","nahhcimkjhjgb","cdgkbn","nnklfbeecgedie","gmllmjbodhgllc","hogollongjo","fmoinacebll","fkngbganmh","jgdblmhlmfij","fkkdjknahamcfb","aieakdokibj","hddlcdiailhd","iajhmg","jenocgo","embdib","dghbmljjogka","bahcggjgmlf","fb","jldkcfom","mfi","kdkke","odhbl","jin","kcjmkggcmnami","kofig","bid","ohnohi","fcbojdgoaoa","dj","ifkbmbod","dhdedohlghk","nmkeakohicfdjf","ahbifnnoaldgbj","egldeibiinoac","iehfhjjjmil","bmeimi","ombngooicknel","lfdkngobmik","ifjcjkfnmgjcnmi","fmf","aoeaa","an","ffgddcjblehhggo","hijfdcchdilcl","hacbaamkhblnkk","najefebghcbkjfl","hcnnlogjfmmjcma","njgcogemlnohl","ihejh","ej","ofn","ggcklj","omah","hg","obk","giig","cklna","lihaiollfnem","ionlnlhjckf","cfdlijnmgjoebl","dloehimen","acggkacahfhkdne","iecd","gn","odgbnalk","ahfhcd","dghlag","bchfe","dldblmnbifnmlo","cffhbijal","dbddifnojfibha","mhh","cjjol","fed","bhcnf","ciiibbedklnnk","ikniooicmm","ejf","ammeennkcdgbjco","jmhmd","cek","bjbhcmda","kfjmhbf","chjmmnea","ifccifn","naedmco","iohchafbega","kjejfhbco","anlhhhhg"};
//        String[] wordDict = {"leet", "code"};
//        String[] wordDict = {"cats", "dog", "sand", "and", "cat"};
//        String[] wordDict = {"aaaa","aaa"};
        String[] wordDict = {"apple","pen"};
        List<String> list = Arrays.asList(wordDict);
//        System.out.println( new WordBreak().wordBreak("fohhemkkaecojceoaejkkoedkofhmohkcjmkggcmnami", list));;
        System.out.println( new WordBreak().wordBreak("applepenapple", list));;
//        System.out.println( new WordBreak().wordBreak("catsandog", list));;
        System.out.println( new WordBreak().wordBreak("aaaaaaa", list));;
        int[] n = new int[]{-1};
    }
}
