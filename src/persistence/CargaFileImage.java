package persistence;

import model.ImagePrincipal;
import java.io.*;

public class CargaFileImage implements CargaImage {
    private File[] files;
    private int index=0;
    
    public CargaFileImage(File folder){
        this.files=folder.listFiles(imageType());
    }
    private FileFilter imageType(){
        return new FileFilter(){
            @Override
            public boolean accept(File pathname){
                return pathname.getPath().endsWith(".jpg");
            }
        };
    }
    
    @Override
    public ImagePrincipal load(){
        return imageAt(index);
    }
    private ImagePrincipal imageAt(int i){
        return new ImagePrincipal(){
            @Override
            public ImagePrincipal next(){
                return imageAt(i+1 >=files.length ? 0 : i+1);
            }
            @Override
            public ImagePrincipal prev(){
                return imageAt(i-1 <0 ? files.length-1 : i-1);
            }
            @Override
            public InputStream stream(){
                try{
                    return new BufferedInputStream(new FileInputStream(files[i]));
                }catch(FileNotFoundException e){
                    return null;
                }
            }
            @Override
            public String name(){
                return files[i].getName();
            }
        };
    }
}
