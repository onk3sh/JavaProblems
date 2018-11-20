package strings;

import java.io.IOException;
import java.util.Scanner;

public class ACMTeam {

    // Complete the acmTeam function below.
    static int[] acmTeam(String[] topic) {
    	int[] res = new int[2];
    	int maxSkills = 0, maxSkillsTeam = 0;
    	int n = topic.length;
    	for(int i = 0; i<n; i++) {
    		for(int j = i+1;j<n;j++) {
    			String team1 = topic[i];
    			String team2 = topic[j];
    			int skillSet = 0;
    			for(int k = 0; k<team1.length();k++) {
    				if(team1.charAt(k) == '1' || team2.charAt(k) == '1')
    					skillSet++;
    			}
    			maxSkillsTeam+= (maxSkills == skillSet) ? 1 : 0;
    			if(skillSet > maxSkills) {
    				maxSkillsTeam = 1;
    				maxSkills = skillSet;
    			}
    		}
    	}
    	res[0] = maxSkills;
    	res[1] = maxSkillsTeam;
    	return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        String[] topic = new String[n];

        for (int i = 0; i < n; i++) {
            String topicItem = scanner.nextLine();
            topic[i] = topicItem;
        }

        int[] result = acmTeam(topic);

        for (int i = 0; i < result.length; i++) {
           System.out.print(String.valueOf(result[i]));

            if (i != result.length - 1) {
                System.out.print("\n");
            }
        }

        scanner.close();
    }
}

