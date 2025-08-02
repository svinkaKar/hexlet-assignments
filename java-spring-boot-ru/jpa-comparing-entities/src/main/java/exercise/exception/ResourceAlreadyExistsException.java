package exercise.exception;

// BEGIN
public class ResourceAlreadyExistsException extends RuntimeException {
    public ResourceAlreadyExistsException(final String message) {
        super(message);
    }
}
// END
