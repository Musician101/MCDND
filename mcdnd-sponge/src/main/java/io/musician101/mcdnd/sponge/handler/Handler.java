package io.musician101.mcdnd.sponge.handler;

@FunctionalInterface
public interface Handler<H>
{
    H handle();
}
