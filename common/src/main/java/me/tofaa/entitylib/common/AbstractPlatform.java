package me.tofaa.entitylib.common;

import me.tofaa.entitylib.*;
import me.tofaa.entitylib.event.EventHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.logging.Logger;
import java.util.stream.Stream;

public abstract class AbstractPlatform<P> implements Platform<P> {


    protected final P handle;
    protected Logger logger;
    private EventHandler eventHandler;
    private EntityIdProvider entityIdProvider;
    private EntityUuidProvider entityUuidProvider;

    public AbstractPlatform(P handle) {
        this.handle = handle;
        this.entityIdProvider = new EntityIdProvider.DefaultEntityIdProvider();
        this.entityUuidProvider = new EntityUuidProvider.DefaultEntityUuidProvider();
    }

    @Override
    public void setupApi(@NotNull APIConfig settings) {
        this.eventHandler = EventHandler.create();
        this.entityIdProvider = new EntityIdProvider.DefaultEntityIdProvider();
        this.entityUuidProvider = new EntityUuidProvider.DefaultEntityUuidProvider();
    }

    @NotNull
    @Override
    public Logger getLogger() {
        return logger;
    }

    @NotNull
    @Override
    public EntityIdProvider getEntityIdProvider() {
        return entityIdProvider;
    }

    @NotNull
    @Override
    public EntityUuidProvider getEntityUuidProvider() {
        return entityUuidProvider;
    }

    @Override
    public void setEntityIdProvider(@NotNull EntityIdProvider entityIdProvider) {
        this.entityIdProvider = entityIdProvider;
    }

    @Override
    public void setEntityUuidProvider(@NotNull EntityUuidProvider entityUuidProvider) {
        this.entityUuidProvider = entityUuidProvider;
    }

    @NotNull
    @Override
    public EventHandler getEventHandler() {
        return eventHandler;
    }

    @NotNull
    @Override
    public P getHandle() {
        return handle;
    }

}
