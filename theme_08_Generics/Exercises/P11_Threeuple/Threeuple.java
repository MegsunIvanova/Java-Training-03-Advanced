package theme_08_Generics.Exercises.P11_Threeuple;

public class Threeuple<F, S, T> {

    private F first;
    private S second;
    private T third;

    public Threeuple(F first, S second, T third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public F getFirst() {
        return this.first;
    }

    public S getSecond() {
        return this.second;
    }

    public T getThird() {
        return this.third;
    }

    public void setFirst(F first) {
        this.first = first;
    }

    public void setSecond(S second) {
        this.second = second;
    }

    public void setThird(T third) {
        this.third = third;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(first);
        stringBuilder.append(" -> ");
        stringBuilder.append(second);
        stringBuilder.append(" -> ");
        stringBuilder.append(third);
        return stringBuilder.toString();
    }
}
