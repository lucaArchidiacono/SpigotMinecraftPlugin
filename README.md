# SpigotMinecraftPlugin-Steal-Items:whale:

## Setup
For this plugin you need a local minecraftserver. I recommend to use Spigot as [localserver](https://getbukkit.org/download/spigot).

If you use OS X you will need to install java from the Apple's [website](http://support.apple.com/kb/DL1421).

### 1. Create a New Folder
Open up finder, and create a new folder in your Home folder named "CraftBukkit".

### 2. Download the Serverfile
Download the server files from [here](https://getbukkit.org/download/spigot).

### 3. Move the File
Get the downloaded server files and move it to the created folder "CraftBukkit".

### 4. Running CraftBukkit
To easily start the server you will need a startup script. The following is a basic server script to start your server.

First off, open up TextEdit/Atom/Brasket etc. and type this in:

```
#!/bin/bash
cd "$( dirname "$0" )"
java -Xms1024M -Xmx1024M -jar craftbukkit.jar -o true
```

Save it in your "CraftBukkit" folder as ```start_server.command```

### 5. Allow the script to run
Open up Terminal.app, navigate to the "CraftBukkit" folder and type in:
```chmod a+x start_server.command```
Hit return to run the command.

### 6. Run Server
From this point on you can start the server by double-clicking start_server.command.
You will need to run the server once for it to generate some configuration files.
After setting up the server, build the github-project to a .jar file and copy paste it into the "plugins" folder of your servers location.

### :sos:Warning:sos:
To stop the server, do not close the terminal/command prompt window. Instead, type 'stop' into the console. Closing the terminal window without stopping the server could lead to corruption of the save files.

## How this Plugin Works
Open the Minecraft Application and choose your localhost server.

Add this commandline ```/createMagicStick```.

Once you add the command, you'll get a stick which has magic power.

The power of this stick is, that in a radius of 100 blocks every teammate is throwing his item from his inventory to you.
Those items which you get, will be removed from the inventory from your teammates and instead you will have it in your inventory.

Very powerfull right?

## Helping
The plugin is purely free to use, but any kind of Ether fund for the hard work will be appreciated.

Here my address:

```0x992a99EF34afeb14133006631b69095C2C87BF6f```

Thanks in advance.
