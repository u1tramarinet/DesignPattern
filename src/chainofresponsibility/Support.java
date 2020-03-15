package chainofresponsibility;

public abstract class Support {
    private String name;
    private Support next;

    public Support(String name) {
        this.name = name;
    }

    public Support setNext(Support next) {
        this.next = next;
        return next;
    }

    public final void support(Trouble trouble) {
//        supportRecursive(trouble);
        supportLopping(trouble);
    }

    @Override
    public String toString() {
        return "[" + name + "]";
    }

    protected abstract boolean resolve(Trouble trouble);

    protected void done(Trouble trouble) {
        println(trouble + "is resolved by" + this + ".");
    }

    protected void fail(Trouble trouble) {
        println(trouble + " cannot be resolved.");
    }

    protected void println(String message) {
        System.out.println(message);
    }

    private void supportRecursive(Trouble trouble) {
        if (resolve(trouble)) {
            done(trouble);
        } else if (next != null) {
            next.support(trouble);
        } else {
            fail(trouble);
        }
    }

    private void supportLopping(Trouble trouble) {
        for (Support support = this; true; support = support.next) {
            if (support.resolve(trouble)) {
                support.done(trouble);
                break;
            } else if (support.next == null) {
                support.fail(trouble);
                break;
            }
        }
    }
}
