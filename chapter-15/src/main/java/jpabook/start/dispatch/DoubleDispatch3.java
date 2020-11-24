package jpabook.start.dispatch;

import java.util.Arrays;
import java.util.List;

public class DoubleDispatch3 {

    interface Post {
        void postOn(Facebook sns);
        void postOn(Twitter sns);
    }

    static class Text implements Post {
        @Override
        public void postOn(Facebook sns) {
            System.out.println("text - facebook");
        }

        @Override
        public void postOn(Twitter sns) {
            System.out.println("text - twitter");
        }
    }

    static class Picture implements Post {
        @Override
        public void postOn(Facebook sns) {
            System.out.println("picture - facebook");
        }

        @Override
        public void postOn(Twitter sns) {
            System.out.println("picture - twitter");
        }
    }

    interface SNS { }

    static class Facebook implements SNS { }

    static class Twitter implements SNS { }

    static class GooglePlus implements SNS { }

    public static void main(String[] args) {
        List<Post> posts = Arrays.asList(new Text(), new Picture());
        List<SNS> sns = Arrays.asList(new Facebook(), new Twitter());

        //posts.forEach(p -> sns.forEach((SNS s)  -> p.postOn(s)));
    }

}
