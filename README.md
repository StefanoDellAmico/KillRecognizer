# KillRecognizer for Apex: Legends
 OBS / Streamlabs / Xsplit Layer. 
 Useful for streamer who'd like to play some kill challanges with automatic update of the kill counter.

## How to use that:

### Prerequisite:
 Due to the fact that the plugin is Java-based, you'll need a _Juva Runtime Environment_ to start it. 
 Based on an A.I., the software need a _screenshot_ of the "kill" symbol that appear whenever you gain an assist or a kill during the match. The size of the screenshot must look like a hitbox of the skull (just it!), and has to be scaled just as the streaming preview (if you're using 2 pc) inside the streamcaster program, or just like in game (but pay attention to the screen resolution). If you will download the `./Release` folder you'll see that i already put two skulls inside it (based on a 1920x1080 screen resolution, and 1:1 scaled screen). If you have a different resolution, just replace them: be sure to rename them properly as i did.
 
 ### Usage:
 If you're a streamer, go to https://github.com/StefanoDellAmico/KillRecognizer/tree/main/Release and download all the files: they're all required.
 
 Then, import as local file in your streamcaster program the "index.html" file. Then, start "KillRecognizer.jar": as far as GUI is not released (yet), it's possible to start it by entering in Command Prompt in the root folder, and type `java -jar KillRecognizer.jar`. If you don't know if the program is not working, don't worry: the Jar file is able to output what he found and what he is doing.

## For the skeptical ones:
 If you don't know what you're downloading, here is the answer: the upper folder (https://github.com/StefanoDellAmico/KillRecognizer/tree/main/) contains all source code for  this release. 
 If you don't trust the `./Release` folder contents, you'll need a Java compiler (i used Eclipse), import an existing project, and import sikuliX and Tess4J libraries as "External Archives", in order to compile it correctly. Once the project will be imported correctly, you'll be able to see the source code, modify it, and compile it.

# Known Issues
 - The software is able to understand how many kills you've done by looking at the top-right corner for the kill symbol, and then by scanning and using OCR technology. If you kill your enemies and they're the last squad remaining, the game will not update the last kill(s), and so the plugin. So by that, i'm looking for a way to update it manually (always better than update everything manually ;) )
 - Accuracy of the OCR is very high, but rarely fails. I acted in two ways:
   - Firstly, i used some conditions inside the code, so the A.I will not change the right values to strage ones.
   - Secondly, i'm working on training the A.I. by recognizing just _Apex: Legends_ font as best as i can. The problem is that Apex has a customized font, that i was not able to find online. If you want to help, open a Pull requests issue and i'll look into it.

# Special thanks
I would like to thanks the Twitch italian streamer **_HALtv_** (https://www.twitch.tv/haltv), who inspired me, and the Twitch italian streamer **_roke_13_** (https://www.twitch.tv/roke_13, my brother) for having helped me by testing the software. 
