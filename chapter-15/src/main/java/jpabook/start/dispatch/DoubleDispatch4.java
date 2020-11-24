package jpabook.start.dispatch;

import java.util.Arrays;
import java.util.List;

public class DoubleDispatch4 {

    interface Post {
        void postOn(SNS sns);
    }

    static class Text implements Post {
        @Override
        public void postOn(SNS sns) {
            sns.post(this);
        }
    }

    static class Picture implements Post {
        @Override
        public void postOn(SNS sns) {
            sns.post(this);
        }
    }

    interface SNS {
        void post(Text post);
        void post(Picture post);
    }

    static class Facebook implements SNS {
        @Override
        public void post(Text post) {
            System.out.println("text - facebook");
        }

        @Override
        public void post(Picture post) {
            System.out.println("picture - facebook");
        }
    }

    static class Twitter implements SNS {
        @Override
        public void post(Text post) {
            System.out.println("text - twitter");
        }

        @Override
        public void post(Picture post) {
            System.out.println("picture - twitter");
        }
    }

    static class GooglePlus implements SNS {
        @Override
        public void post(Text post) {
            System.out.println("text - google plus");
        }

        @Override
        public void post(Picture post) {
            System.out.println("picture - google plus");
        }
    }

    public static void main(String[] args) {
        List<Post> posts = Arrays.asList(new Text(), new Picture());
        List<SNS> sns = Arrays.asList(new Facebook(), new Twitter(), new GooglePlus());

        posts.forEach(p -> sns.forEach((SNS s)  -> p.postOn(s)));

        // 1. Post에 의한 dynamic dispatch
        // 2. SNS에 의한 dynamic dispatch

        // double dispatch는 코드 가독성이 떨어지고 성능에도 영향이 있다.
    }

}
