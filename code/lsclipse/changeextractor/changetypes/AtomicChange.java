package changetypes;

public class AtomicChange {
	
	public enum Modifier {
		ADDED,
		DELETED,
		MODIFIED,
		BEFORE,
		AFTER,
	}

	public Modifier mod;
	public Fact fact;

	private AtomicChange(Modifier mod, Fact fact) {
		this.mod = mod;
		this.fact = fact;
	}

	public AtomicChange(AtomicChange f) {
		this.mod = f.mod;
		this.fact = f.fact;
	}

	public int hashCode() {
		return fact.hashCode();
	}
	public boolean equals(Object o) {
		if (o.getClass()!=this.getClass()) return false;
		AtomicChange f = (AtomicChange)o;
		if (!mod.equals(f.mod)) return false;
		if (!fact.equals(f.fact)) return false;
		return true;
	}

	public String toString() {
		return mod.toString().toLowerCase()+"_"+fact.toString();
	}
	
	public static AtomicChange makeChange(Modifier mod, Fact fact) {
		return new AtomicChange(mod, fact);
	}
}

