package io.musician101.sponge.mcdnd.handler;

@FunctionalInterface
public interface Handler<H>
{
    H handle();
}
