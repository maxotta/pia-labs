package cz.kiv.zcu.pia.core.posts.service;

/**
 * Exception thrown when connection to webservice fails to return with 200 OK.
 *
 * Contains HTTP return status of failed connection.
 *
 * Date: 11.12.14
 *
 * @author Jakub Danek
 */
public class PostServiceException extends Exception {

    private final int status;

    public PostServiceException(int status) {
        this.status = status;
    }

    public PostServiceException(String message, int status) {
        super(message);
        this.status = status;
    }

    public PostServiceException(String message, Throwable cause, int status) {
        super(message, cause);
        this.status = status;
    }

    public PostServiceException(Throwable cause, int status) {
        super(cause);
        this.status = status;
    }

    public PostServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, int status) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.status = status;
    }

    /**
     *
     * @return returned status of the HTTP response
     */
    public int getStatus() {
        return status;
    }
}
