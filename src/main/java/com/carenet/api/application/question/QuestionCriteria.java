package com.carenet.api.application.question;

public class QuestionCriteria {

    public record Create(String name) {
        public static Create of(String name) {
            return new Create(name);
        }

        // toCriteria 는 request 에서 만들어지잖아
//        public Create toCriteria(QuestionDto.Request request) {
//            return Create.of(request.name());
//        }
    }

}
