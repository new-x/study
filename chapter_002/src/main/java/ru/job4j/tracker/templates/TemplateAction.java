package ru.job4j.tracker.templates;

/**
 * Class TemplateAction
 *
 * @author alekseev
 * @since mm-dd-yyyy
 */
public abstract class TemplateAction {
    public TemplateAction(String name){
    }

    abstract void start();
    abstract void finish();

    public void work() {
        this.start();
        this.finish();
    }

    public static void main(String[] args) {
         new TemplateAction("String"){
           public void start(){
           }
           public void finish() {
           }
         };
    }
}
