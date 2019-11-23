package two.x.two.entity;

public class Word {
    int i;
    int l;
    String ner;
    String v;

    public Word() {
    }

    public Word(int i, int l, String ner, String v) {
        this.i = i;
        this.l = l;
        this.ner = ner;
        this.v = v;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getL() {
        return l;
    }

    public void setL(int l) {
        this.l = l;
    }

    public String getNer() {
        return ner;
    }

    public void setNer(String ner) {
        this.ner = ner;
    }

    public String getV() {
        return v;
    }

    public void setV(String v) {
        this.v = v;
    }

    @Override
    public String toString() {
        return "Word{" +
                "i=" + i +
                ", l=" + l +
                ", ner='" + ner + '\'' +
                ", v='" + v + '\'' +
                '}';
    }
}
