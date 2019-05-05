package com.zhousx.demo.newCharacter;

@FunctionalInterface
interface IConvert<F,T> {
    T convert(F form);
}
