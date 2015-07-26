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
		subject = null;
		action = null;
		prep = null;
		target = null;
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
}
