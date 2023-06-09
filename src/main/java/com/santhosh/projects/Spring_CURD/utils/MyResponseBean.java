package com.santhosh.projects.Spring_CURD.utils;

import lombok.Getter;
import lombok.Setter;

@Getter
//@Setter
public class MyResponseBean<T> {
    private T data;
    private String message;
    private Boolean success;

    // Constructor (private to enforce builder pattern)
    private MyResponseBean(T data, String message, Boolean success) {
        this.data = data;
        this.message = message;
        this.success = success;
    }

    // Builder pattern methods
    public static <T> Builder<T> builder() {
        return new Builder<>();
    }

    public static class Builder<T> {
        private T data;
        private String message;
        private Boolean success;

        public Builder<T> data(T data) {
            this.data = data;
            return this;
        }

        public Builder<T> message(String message) {
            this.message = message;
            return this;
        }

        public Builder<T> success(Boolean success) {
            this.success = success;
            return this;
        }

        public MyResponseBean<T> build() {
            return new MyResponseBean<>(data, message, success);
        }
    }

}

