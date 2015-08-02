package naturalLanguageProcessor;

/*
 * Purpose:	Describe a prepositional phrase of the form noun -> verb -> preposition -> noun
 */
public class PrepClauseFrame implements Frame {

	private Noun subject;
	private Verb action;
	private Preposition prep;
	private Noun target;
	
	/*
	 * Purpose:	Initialize an empty frame
	 */
	public PrepClauseFrame() {
		reset();
	}
	
	/*
	 * Purpose:	Initialize a fully formed frame
	 */
	public PrepClauseFrame(Noun subject, Verb action, Preposition prep, Noun target) {
		this.subject = subject;
		this.action = action;
		this.prep = prep;
		this.target = target;
	}
	
	/*
	 * Purpose:	Add a generic word to the frame. If the word is in the wrong order, reset
	 */
	public void add(Word word) {
		String wordType = word.getClass().getSimpleName();
		switch (wordType) {
		case "Noun":
			if (prep != null && target == null) {
				target = (Noun) word;
			} else {
				reset();
				subject = (Noun) word;
			}
			break;
		case "Verb":
			if (subject != null && action == null) {
				action = (Verb) word;
			} else {
				reset();
			}
			break;
		case "Preposition":
			if (action != null && prep == null) {
				prep = (Preposition) word;
			} else {
				reset();
			}
			break;
		}
	}
	
	/*
	 * Purpose:	Reset the frame to blank
	 */
	public void reset() {
		subject = null;
		action = null;
		prep = null;
		target = null;
	}
	
	/*
	 * Purpose:	set the preposition in this clause
	 */
	public void setPrep(Preposition prep) {
		this.prep = prep;
	}
	
	/*
	 * Purpose:	setter method for subject
	 */
	public void setSubject(Noun subject) {
		this.subject = subject;
	}
	
	/*
	 * Purpose:	setter method for target
	 */
	public void setTarget(Noun target) {
		this.target = target;
	}
	
	/*
	 * Purpose:	setter method for action
	 */
	public void setAction(Verb action) {
		this.action = action;
	}
	
	/*
	 * Purpose:	get method for prep
	 * Returns:	prep
	 */
	public Preposition getPrep() {
		return prep;
	}
	
	/*
	 * Purpose:	get method for subject
	 * Returns:	subject
	 */
	public Noun getSubject() {
		return subject;
	}
	
	/*
	 * Purpose: get method for target
	 * Returns: target
	 */
	public Noun getTarget() {
		return target;
	}
	
	/*
	 * Purpose:	get method for action
	 * Returns:	action
	 */
	public Verb getAction() {
		return action;
	}
	
	/*
	 * Purpose: determine if a clause frame is complete
	 * Returns:	true if all members of the frame are non-null, otherwise false
	 */
	public boolean isComplete() {
		return target != null;
	}
	
	/*
	 * Purpose:	string representation of the Frame
	 * Returns: the words in the clause
	 */
	public String toString() {
		return subject.getWord() + " " + action.getWord() + " " +
				prep.getWord() + " " + target.getWord();
	}
}
