import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        List<Message> messages = new ArrayList<>();
        
        for (String infos : record) {
            String[] info = infos.split(" ");
            String behave = info[0];
            String id = info[1];
            
            if (!behave.equals("Leave")) {
                String name = info[2];
                map.put(id, name);
            }
            
            if (!behave.equals("Change")) {
                messages.add(new Message(id, behave));   
            }
        }
        
        String[] answer = new String[messages.size()];
        for (int i = 0; i < messages.size(); i++) {
            Message message = messages.get(i);
            String name = map.get(message.getId());
            answer[i] = message.printMessage(name);
        }
        
        return answer;
    }
    
    private class Message {
        String id;
        String behave;
        
        public Message(String id, String behave) {
            this.id = id;
            this.behave = behave;
        }
        
        public String getId() { return id; }
        
        public String printMessage(String name) {
            switch(this.behave) {
                case "Enter":
                    return name + "님이 들어왔습니다.";
                case "Leave":
                    return name + "님이 나갔습니다.";
            }
            return "";
        }
    }
}