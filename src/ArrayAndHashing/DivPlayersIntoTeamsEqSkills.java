package ArrayAndHashing;

import java.util.HashMap;

public class DivPlayersIntoTeamsEqSkills {
    public long dividePlayers(int[] skill) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int n = skill.length, score = 0, pairs = n / 2;
        long ans = 0;

        for (int e : skill)
            score += e;

        int rem = (score % pairs);
        if (rem != 0)
            return -1;

        score = (score / pairs);

        for (int i = 0; i < n; i++) {
            int need = score - skill[i];

            if (map.containsKey(need)) {
                int f = map.get(need);

                if (f == 1) {
                    map.remove(need);
                } else
                    map.put(need, f - 1);

                ans += (need * skill[i]);
                pairs--;
            } else
                map.put(skill[i], map.getOrDefault(skill[i], 0) + 1);
        }

        return pairs == 0 ? ans : -1;
    }
}
