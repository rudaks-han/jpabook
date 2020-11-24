package jpabook.start.dispatch;

import java.util.Arrays;
import java.util.List;

public class DoubleDispatch2 {

    interface Post {
        void postOn(SNS sns);
    }

    static class Text implements Post {
        @Override
        public void postOn(SNS sns) {
            if (sns instanceof Facebook) {
                System.out.println("text - facebook");
            } else if (sns instanceof Twitter) {
                System.out.println("text - twitter");
            } else if (sns instanceof GooglePlus) {
                System.out.println("text - google plus");
            }
        }
    }

    static class Picture implements Post {
        @Override
        public void postOn(SNS sns) {
            if (sns instanceof Facebook) {
                System.out.println("picture - facebook");
            } else if (sns instanceof Twitter) {
                System.out.println("picture - twitter");
            } else if (sns instanceof GooglePlus) {
                System.out.println("text - google plus");
            }
        }
    }

    interface SNS { }

    static class Facebook implements SNS { }

    static class Twitter implements SNS { }

    static class GooglePlus implements SNS { }

    public static void main(String[] args) {
        List<Post> posts = Arrays.asList(new Text(), new Picture());
        List<SNS> sns = Arrays.asList(new Facebook(), new Twitter());

        posts.forEach(p -> sns.forEach(s -> p.postOn(s)));
    }

}
