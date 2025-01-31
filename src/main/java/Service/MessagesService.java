package Service;

import DAO.MessagesDAO;
import Model.Message;
import java.util.List;

public class MessagesService {
    public MessagesDAO messagesDAO;

    public MessagesService(){
        messagesDAO = new MessagesDAO();
    }
    
    public MessagesService(MessagesDAO messagesDAO){
        this.messagesDAO = messagesDAO;
    }

    /*
    The creation of the message will be successful if and only if the message_text is not blank, 
    is not over 255 characters, 
    and posted_by refers to a real, existing user.
    */
    public Message addMessage(Message message) {
        if(message.getMessage_text().length() <= 0 || message.getMessage_text().length() > 255){
            return null;
        }
        if(!messagesDAO.checkIfUserExists(message.getPosted_by())){
            return null;
        }
        return messagesDAO.postMessage(message);
    }

    /*
    The response body should contain a JSON representation of a list containing all messages retrieved from the database.
    */
    public List<Message> getAllMessages() {
        return messagesDAO.getAllMessages();
    }

    /*
    The response body should contain a JSON representation of the message identified by the message_id.
    */
    public Message getMessageById(int messageId) {
        return messagesDAO.getMessageById(messageId);
    }

    /*
    If the message existed, the response body should contain the now-deleted message.
    */
    public Message deleteMessageById(int messageId) {
        return messagesDAO.deleteMessage(messageId);
    }

    /*
    The response body should contain a JSON representation of the message identified by the message_id.
    It is expected for the response body to simply be empty if there is no such message.
    */
    public Message updateMessageById(int messageId, Message message) {
        return messagesDAO.updateMessage(messageId, message);
    }

    /*
    The response body should contain a JSON representation of a list containing all messages posted by a particular user, which is retrieved from the database. 
    It is expected for the list to simply be empty if there are no messages. 
    */
    public List<Message> getAllMessagesFromUser(int user) {
        return messagesDAO.getAllMessagesFromAccount(user);
    }
}
