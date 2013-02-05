/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package timeprogressbar;

import javax.swing.JProgressBar;

/**
 *
 * @author MOHANET-KATA
 */
public class TimeProgressBar extends JProgressBar  {
    
    private float maxLength = Float.MAX_VALUE;
    private boolean run;
    private Thread timerThread;
    
    public TimeProgressBar() {
        super();
        setStringPainted(true);
        initThread();
    }
    
//    @Override
//    public String getString() {
//        int max = getMaximum();
//        return super.getString() + (max - getValue());
//    }
    
    private void initThread() {
       timerThread = new Thread() {
            @Override
            public void run() {
                run = true;
                long start = System.currentTimeMillis();
                double millis = 0;
                while ( millis / 1000 < maxLength && run) {
                    long now = System.currentTimeMillis();
                    millis = now - start;
                    float percent = ((float)(now - start) / 1000) / maxLength * 100;
                    setValue((int)percent);

                    int hours = (int)(millis / 1000 / 60 / 60);
                    int minutes = (int)( (millis - hours * 60 * 60 * 1000) / 1000 / 60 );
                    int seconds = (int)( (millis - hours * 60 * 60 * 1000 
                                                 - minutes * 60 * 1000) / 1000 );
                    StringBuilder sb = new StringBuilder();

                    if ( hours != 0 ) sb.append(hours);
                    boolean beginWithZero = hours != 0 && minutes < 10;
                    sb.append( beginWithZero ? "0" : "")
                      .append(minutes)
                      .append(":");
                    sb.append( seconds < 10 ? "0" : "")
                      .append(seconds);

                    setString( sb.toString() );
                    repaint();
                }
            }
        };
    }
    
    public void start() {
        super.setMaximum(100);
        initThread();
        run = true;
        timerThread.start();
    }
    
    public void stop() {
        run = false;
    }

    public boolean isRun() {
        return timerThread.isAlive();
    }

    public float getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(float maxLength) {
        this.maxLength = maxLength;
    }

    public Thread getTimerThread() {
        return timerThread;
    }

}
