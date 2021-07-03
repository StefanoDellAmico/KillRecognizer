# KillRecognizer
 OBS / Streamlabs / Xsplit Layer. 
 Useful for streamer who'd like to play some kill challanges with automatic update of the kill counter.

## How to use that:
 If you're a streamer, go to https://github.com/StefanoDellAmico/KillRecognizer/tree/main/Release and download all the files: they're all required.
 
 Then, import as local file in your streamcaster program the "index.html" file. Then, start "KillRecognizer.jar": as far as GUI is not released (yet), it's possible to start it by entering in Command Prompt in the root folder, and type `java -jar KillRecognizer.jar`. If you don't know if the program is not working, don't worry: the Jar file is able to output what he found and what he is doing.

## For who is Sceptic
 If you don't know what you're downloading, the here is the answer: the upper folder (https://github.com/StefanoDellAmico/KillRecognizer/tree/main/) contains all source code for  this release. 
 If you don't trust the release folder, you'll need a Java compiler, and import sikuliX and Tess4J libraries as External Jar, so you will be capabale of see the entire source code.

# Known Issues
 - The software is able to understand how many kills you've done by looking at the top-right corner for the kill symbol, and then by scanning and using OCR technology. If you kill your enemies and they're the last squad remaining, the game will not update the last kill(s), and so the plugin. So by that, i'm looking for a way to update it manually (always better than update everything manually ;) )
 - Accuracy of the OCR is very high, but rarely fails. I acted in two ways:
   - Firstly, i used some conditions inside the code, so the A.I will not change the right values to strage ones.
   - Secondly, i'm working on training the A.I. by recognizing just Apex: Legends font as best as i can. The problem is that Apex has a customized font, that i was not able to find online. If you want to help, open a Pull requests issue and i'll look into it.

# Special thanks
I would like to thanks the Twitch italian streamer **_HALtv_** (https://www.twitch.tv/haltv), who inspired me, and the Twitch italian streamer **_roke_13_** (https://www.twitch.tv/roke_13, my brother) for having helped me by testing the software. 
