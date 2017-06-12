package entry;

/**
 * Created by msi on 2017/6/11.
 */

public class HomePage {
    public int mIconRes;
    public String mText;

    public HomePage(Builder builder) {
        this.mIconRes = builder.mIconRes;
        this.mText = builder.mText;
    }

    @Override
    public String toString() {
        return "HomePage{" +
                "mIconRes=" + mIconRes +
                ", mText='" + mText + '\'' +
                '}';
    }

    public static class Builder {
        private int mIconRes;
        private String mText;

        public Builder setIcon(int iconRes) {
            this.mIconRes = iconRes;
            return this;
        }

        public Builder setText(String text) {
            this.mText = text;
            return this;
        }

        public HomePage build() {
            return new HomePage(this);
        }
    }
}
