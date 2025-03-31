import java.util.ArrayList;
import java.util.List;

public class JIdea extends JContent implements Comparable<JIdea> {

    private List<JAttachment> attachments = new ArrayList<JAttachment>();
    private JState state;

    public JIdea(String tittle, String description) {
        super(tittle, description);
        this.state = new Draft();
    }

    public void discuss(String text){
        state.setCurrentDiscussion(text);
    }
    public void evaluate(JValuation valuation){
        state.evaluate(valuation);
    }
    public void hold(){
        state.hold();
    }
    public void release(){
        state.release();
    }
    public void decline(){
        state.decline();
    }
    public boolean isDeclined(){
        return state instanceof DeclinedIdea;
    }
    public boolean isReleased(){
        return state instanceof ReleasedIdea;
    }
    public String getCurrentDiscussion(){
        return state.getCurrentDiscussion();
    }
    public JValuation getValuation(){
        return state.getValuation();
    }
    public void addAttachment(JAttachment attachment){
        if (attachment == null){
            throw new NullPointerException();
        }
        attachments.add(attachment);
    }
    public List<JAttachment> getAttachments(){
        return attachments;
    }
    public boolean removeAttachment(JAttachment attachment){
        if (attachment == null){
            throw new NullPointerException();
        }
        if (attachments.contains(attachment)){
            attachments.remove(attachment);
            return true;
        }else {
            return false;
        }
    }
    public String toString(){
        return "Idea" + ": " + getTitle() + "\n" + getDescription();
    }

    public int compareTo(JIdea idea){
        return getTitle().compareTo(idea.getTitle());
    }
    public boolean equals(Object o){
        if (o instanceof JIdea){
            JIdea i = (JIdea)o;
            return getTitle().equals(i.getTitle());
        }
        return false;
    }
    public int hashCode(){
        return getTitle().hashCode();
    }


    // _____________________________________ STATE ______________________________________________
    public abstract class JState {

        public String currentDiscussion = "";
        private JValuation valuation;
        public void evaluate(JValuation valuation){
            throw new IllegalStateException();
        }
        public void hold(){
            throw new IllegalStateException();
        }
        public void release(){
            throw new IllegalStateException();
        }
        public void decline(){
            throw new IllegalStateException();
        }
        public void discuss(String text){
            throw new IllegalStateException();
        }
        public void setCurrentDiscussion(String currentDiscussion) {
            throw new IllegalStateException();
        }
        public String getCurrentDiscussion() {
            return currentDiscussion;
        }

        public JValuation getValuation() {
            return valuation;
        }

        public void setValuation(JValuation valuation) {
            if(valuation == null){
                throw new NullPointerException();
            }
            this.valuation = valuation;
        }

    }

    public class Draft extends JState {
        private JIdea idea;
        @Override
        public void hold() {
            state = new OpenDraft();
        }
        @Override
        public void decline() {
            state = new DeclinedIdea();
        }
    }

    public class OpenDraft extends JState {
        private JIdea idea;
        @Override
        public void discuss(String text) {
            if(text.isEmpty()){
                throw new IllegalArgumentException();
            }
            setCurrentDiscussion(text);
        }
        @Override
        public void setCurrentDiscussion(String currentDiscussion) {
            if(currentDiscussion.isEmpty()){
                throw new IllegalArgumentException();
            }
            this.currentDiscussion = getCurrentDiscussion() + currentDiscussion + "\n";
        }
        @Override
        public void evaluate(JValuation valuation) {
            if (valuation == null){
                throw new NullPointerException();
            }
            setValuation(valuation);
        }
        @Override
        public void hold() {
            state = new ApprovedIdea();
        }
        @Override
        public void decline() {
            state = new DeclinedIdea();
        }
    }
    public class ApprovedIdea extends JState {
        @Override
        public void release() {
            state = new ReleasedIdea();
        }
    }
    public class ReleasedIdea extends JState {}
    public class DeclinedIdea extends JState {}
    // __________________________________________________________________________________________

}