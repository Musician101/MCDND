package io.musician101.mcdnd.sponge.data.manipulator.builder.common;

import java.util.List;
import javax.annotation.Nonnull;
import org.spongepowered.api.data.manipulator.immutable.ImmutableListData;
import org.spongepowered.api.data.manipulator.mutable.ListData;

public abstract class ListDataManipulatorBuilder<V, M extends ListData<V, M, I>, I extends ImmutableListData<V, I, M>> extends SingleValueDataManipulatorBuilder<List<V>, M, I> {

    @Nonnull
    @Override
    public ListDataManipulatorBuilder<V, M, I> from(@Nonnull M value) {
        this.value = value.asList();
        return this;
    }

    @Nonnull
    @Override
    public ListDataManipulatorBuilder<V, M, I> reset() {
        value = null;
        return this;
    }
}
