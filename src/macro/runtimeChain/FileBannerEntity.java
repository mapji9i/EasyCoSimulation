package macro.runtimeChain;

import macro.Utils.ReadFileUtils;
import macro.Logger;

public class FileBannerEntity extends BannerEntity{
    private String bannerFilePath=null;
    public FileBannerEntity(Logger logger, String bannerFilePath) {
        super(logger);
        this.bannerFilePath=bannerFilePath;
        readBannerFromFile();
    }

    private void readBannerFromFile(){
        this.banner= ReadFileUtils.ReadAllFileAsString(bannerFilePath);
    }

}
