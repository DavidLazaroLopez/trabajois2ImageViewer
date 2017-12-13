package model;

import java.io.InputStream;

public interface ImagePrincipal {
    public String name();
    public InputStream stream();
    public ImagePrincipal next();
    public ImagePrincipal prev();
}
