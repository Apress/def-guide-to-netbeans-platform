package com.galileo.netbeans.module;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.netbeans.api.queries.FileEncodingQuery;
import org.netbeans.spi.tasklist.FileTaskScanner;
import org.netbeans.spi.tasklist.Task;
import org.openide.filesystems.FileObject;
import org.openide.util.NbBundle;

public class LoggingTaskScanner extends FileTaskScanner {
    
    private static final String GROUP_NAME = "logging-tasklist";

    private static final String[] TOKENS = {
       "System.out.println", 
       "System.err.println", 
       "printStackTrace"};
    
    private Pattern  regexp   = null;
    private Callback callback = null;

   public LoggingTaskScanner(String name, String desc) {
       super(name, name, null);
   }

   public static LoggingTaskScanner create() {
       System.out.println("create");
       String name = NbBundle.getBundle(LoggingTaskScanner.class).getString("LBL_loggingtask");
       String desc = NbBundle.getBundle(LoggingTaskScanner.class).getString("HINT_loggingtask");
       return new LoggingTaskScanner(name, desc);
   }

   public List<? extends Task> scan(FileObject file) {
       System.out.println("scan");
        List<Task> tasks = new LinkedList<Task>();
        
        try {
            String text = getContent( file );
            
            int index = 0;
            int lineno = 1;
            int len = text.length();

            Matcher matcher = getScanRegexp().matcher( text );
            while (index < len && matcher.find(index)) {
                int begin = matcher.start();
                int end   = matcher.end();

                char c = 'a';
                int nonwhite = begin;
                while (begin >= index && (c = text.charAt(begin)) != '\n') {
                    if (c != ' ' && c != '\t') {
                        nonwhite = begin;
                    }
                    --begin;
                }
                
                begin = nonwhite;

                nonwhite = end;
                while (end < len) {
                    c = text.charAt(end);
                    if (c == '\n' || c == '\r') {
                        break;
                    } else if (c != ' ' && c != '\t') {
                            nonwhite = end;
                    }
                    ++end;
                }

                // calculate current line number
                int idx = index;
                while (idx <= begin) {
                    if (text.charAt(idx) == '\n') {// NOI18N
                        ++lineno;
                    }
                    ++idx;
                }
                
                index = end;
                
                String description = text.subSequence(begin, nonwhite+1).toString();
                
                Task task = Task.create( file, GROUP_NAME, description, lineno );
                tasks.add(task);
            }
        } catch( IOException e ) {
            Logger.getLogger( getClass().getName() ).log( Level.INFO, null, e );
        } catch( OutOfMemoryError oomE ) {
            System.gc();
            Logger.getLogger( getClass().getName() ).log( Level.INFO, null, oomE );
        }
        return tasks;
   }

    private String getContent( FileObject fileObject ) throws IOException {
        char[] buf = new char[1024*64];
        StringBuffer sb = new StringBuffer();
        Charset charset = FileEncodingQuery.getEncoding( fileObject );
        Reader r = new BufferedReader(new InputStreamReader(fileObject.getInputStream(), charset));
        int len;
        try {
            while (true) {
                len = r.read(buf);
                if (len == -1) break;
                sb.append(buf, 0, len);
            }
        } finally {
            r.close();
        }
        return sb.toString();
    }    
    
    
    private Pattern getScanRegexp() {
        if (regexp == null) {
            StringBuffer sb = new StringBuffer(200);
            //Collection<String> patterns = Settings.getDefault().getPatterns();
            boolean needSeparator = false;
            for( String s : TOKENS) {
                if( needSeparator ) {
                    sb.append('|');
                }
                needSeparator = true;
                int n = s.length();

                if (Character.isJavaIdentifierPart(s.charAt(0))) {
                    sb.append("\\W"); // NOI18N
                }

                for (int j = 0; j < n; j++) {
                    char c = s.charAt(j);

                    if ((c == '(') || (c == ')') ||
                        (c == '{') || (c == '}') ||
                        (c == '[') || (c == ']') ||
                        (c == '?') || (c == '*') || (c == '+') ||
                        (c == '!') || (c == '|') || (c == '\\') ||
                        (c == '^') || (c == '$')) {
                        sb.append('\\');
                    }
                    sb.append(c);
                }
                if (Character.isJavaIdentifierPart(s.charAt(n-1))) {
                    sb.append("\\b");
                }
            }
            try {
                regexp = Pattern.compile(sb.toString());
            } catch (PatternSyntaxException e) {
                Logger.getLogger(getClass().getName()).log(Level.INFO, null, e);
                return null;
            }
        }
        return regexp;
    }
    
    public void attach(Callback callback) {
        System.out.println("attach");
        if( null == callback && null != this.callback ) {
            regexp = null;
            //Settings.getDefault().removePropertyChangeListener( this );
        } else if( null != callback && null == this.callback ) {
            //Settings.getDefault().addPropertyChangeListener( this );
        }
        this.callback = callback;
    }
    
    @Override
    public void notifyPrepare() {
       System.out.println("notifyPrepare");
        getScanRegexp();
    }

    /** @todo add description */
    @Override
    public void notifyFinish() {
       System.out.println("notifyFinish");
        regexp = null;
    }
}
