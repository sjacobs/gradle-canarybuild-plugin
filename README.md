gradle-canarybuild-plugin
=========================

![canarycage](http://img.washingtonpost.com/rf/image_606w/2010-2019/WashingtonPost/2013/02/22/Editorial-Opinion/Graphics/toles02252013.jpg)

Why 'canary'?
-------------------------
It's an allusion to caged canaries (birds) that miners would carry down into the mine tunnels with them. If dangerous gases such as methane or carbon monoxide leaked into the mine, the gases would kill the canary before killing the miners, thus providing a warning to exit the tunnels immediately.


From ThoughtWorks' technology radar:
> Many projects have external code dependencies, a large amount of which is provided by open source projects. 
> In order to ensure our builds are reproducible, we integrate against known versions of them, but that can 
> mean that it takes a while for us to integrate against newer versions of these libraries leading to a larger 
> merge effort down the line. One approach we have seen to avoid this is to have a nightly Canary Build which 
> tries to pull in the latest version of all dependencies. If the build is green, we know we can change which 
> versions we depend on.

This plugin is about to provide this functionality to make it usable in any gradle project. 
