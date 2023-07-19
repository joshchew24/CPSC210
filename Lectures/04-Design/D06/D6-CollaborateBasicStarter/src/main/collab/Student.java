package collab;

import java.util.*;

public class Student extends Observable {
    private static final List<String> QUESTIONS = new ArrayList<>(Arrays.asList(
            "What's an object?",
            "Could you repeat that?",
            "Will this be on the final exam?"));
    private static final Random random = new Random();

    private String id;
    private String name;

    // EFFECTS: constructs student with id, name and session moderator
    public Student(String id, String name, Moderator moderator) {
        this.id = id;
        this.name = name;
        addObserver(moderator);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // MODIFIES: this
    // EFFECTS: raises this student's hand to ask a question
    public void raiseHand() {
//        moderator.handRaised(this);
        setChanged();
        notifyObservers();
    }

    // MODIFIES: this
    // EFFECTS: returns the text of the question to ask
    public String askQuestion() {
        String question = QUESTIONS.get(random.nextInt(QUESTIONS.size()));
        setChanged();
        notifyObservers(new Question(this, question));
        return question;
    }
}
