import java.util.*;

class Solution {
    static int banSize, userSize, answer;
    static boolean[] visit;
    static Set<Set<String>> id_set;
    
    public int solution(String[] user_id, String[] banned_id) {
        banSize = banned_id.length;
        userSize = user_id.length;
        visit = new boolean[userSize];
        id_set = new HashSet<>();
        
        getUserIdSet(0, new HashSet<>(), user_id, banned_id);
        
        return id_set.size();
    }
    
    static void getUserIdSet(int n, Set<String> set, String[] user_id, String[] ban_id){
        if(n == banSize){
            id_set.add(set);
            return;
        }
        
        for(int i = 0; i < userSize; i++){
            if(set.contains(user_id[i])){
                continue;
            }
            
            if(checkId(user_id[i], ban_id[n])){
                set.add(user_id[i]);
                getUserIdSet(n+1, new HashSet<>(set), user_id, ban_id);
                set.remove(user_id[i]);
            }
        }
    
    }
    
    static boolean checkId(String id, String ban){
        if(id.length() != ban.length()){
            return false;
        }
        
        for(int i = 0; i < id.length(); i++){
            if(ban.charAt(i) == '*'){
                continue;
            }
            
            if(ban.charAt(i) != id.charAt(i)){
                return false;
            }
        }
        
        return true;
    }
}