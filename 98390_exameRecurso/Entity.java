
abstract class Entity {
    protected static StringBuffer indent = new StringBuffer();
    public abstract void draw();
    int count;

    public StringBuffer getIndent() {
        return indent;
    }

    public int count() {
        return count;
    }
    public int getTotalWeight(){
        return 0;
    }

}





