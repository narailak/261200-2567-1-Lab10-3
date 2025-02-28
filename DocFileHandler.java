public class DocFileHandler implements Handler {
    private Handler handler; // whom to pass on request
    private String handlerName;

    public DocFileHandler(String handlerName) {
        this.handlerName = handlerName ;

    }

    @Override
    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void process(File file) {
        if (file.getFileType().equals("doc")) {
            System.out.println("Processing : "+ file.getFilePath() +"/"+ file.getFileName()+" by "+handlerName);
        }else if(handler != null){//มีใครต่อท้ายไหม
            System.out.println(handlerName + " forwards request to " + handler.getHandlerName());
            handler.process(file);//handler คือคนถัดไป
        }
    }
    @Override
    public String getHandlerName() {
        return this.handlerName;
    }

    // TODO: Override setHandler and getHandlerName

}


