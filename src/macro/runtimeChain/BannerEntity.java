package macro.runtimeChain;

import macro.Logger;

abstract class BannerEntity extends ChainEntity{
    protected String banner="Default placeholder";
    public BannerEntity(Logger logger) {
       this.logger=logger;
    }

    @Override
    protected void init() {
        this.output=this.input;
        this.input=null;
    }

    @Override
    protected void extract() {

    }

    @Override
    public void run() {
        logger.print(banner);
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }
}


