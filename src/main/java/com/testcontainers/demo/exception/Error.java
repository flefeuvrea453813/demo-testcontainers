package com.testcontainers.demo.exception;

import lombok.Generated;

import java.util.Date;

public class Error {
    private int status;
    private Date timestamp;
    private String message;
    private String description;

    @Generated
    public static ErrorBuilder builder() {
        return new ErrorBuilder();
    }

    @Generated
    public int getStatus() {
        return this.status;
    }

    @Generated
    public Date getTimestamp() {
        return this.timestamp;
    }

    @Generated
    public String getMessage() {
        return this.message;
    }

    @Generated
    public String getDescription() {
        return this.description;
    }

    @Generated
    public void setStatus(final int status) {
        this.status = status;
    }

    @Generated
    public void setTimestamp(final Date timestamp) {
        this.timestamp = timestamp;
    }

    @Generated
    public void setMessage(final String message) {
        this.message = message;
    }

    @Generated
    public void setDescription(final String description) {
        this.description = description;
    }

    @Generated
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Error)) {
            return false;
        } else {
            Error other = (Error)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getStatus() != other.getStatus()) {
                return false;
            } else {
                label49: {
                    Object this$timestamp = this.getTimestamp();
                    Object other$timestamp = other.getTimestamp();
                    if (this$timestamp == null) {
                        if (other$timestamp == null) {
                            break label49;
                        }
                    } else if (this$timestamp.equals(other$timestamp)) {
                        break label49;
                    }

                    return false;
                }

                Object this$message = this.getMessage();
                Object other$message = other.getMessage();
                if (this$message == null) {
                    if (other$message != null) {
                        return false;
                    }
                } else if (!this$message.equals(other$message)) {
                    return false;
                }

                Object this$description = this.getDescription();
                Object other$description = other.getDescription();
                if (this$description == null) {
                    if (other$description != null) {
                        return false;
                    }
                } else if (!this$description.equals(other$description)) {
                    return false;
                }

                return true;
            }
        }
    }

    @Generated
    protected boolean canEqual(final Object other) {
        return other instanceof Error;
    }

    @Generated
    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        result = result * 59 + this.getStatus();
        Object $timestamp = this.getTimestamp();
        result = result * 59 + ($timestamp == null ? 43 : $timestamp.hashCode());
        Object $message = this.getMessage();
        result = result * 59 + ($message == null ? 43 : $message.hashCode());
        Object $description = this.getDescription();
        result = result * 59 + ($description == null ? 43 : $description.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        int var10000 = this.getStatus();
        return "Error(status=" + var10000 + ", timestamp=" + String.valueOf(this.getTimestamp()) + ", message=" + this.getMessage() + ", description=" + this.getDescription() + ")";
    }

    @Generated
    public Error(final int status, final Date timestamp, final String message, final String description) {
        this.status = status;
        this.timestamp = timestamp;
        this.message = message;
        this.description = description;
    }

    @Generated
    public static class ErrorBuilder {
        @Generated
        private int status;
        @Generated
        private Date timestamp;
        @Generated
        private String message;
        @Generated
        private String description;

        @Generated
        ErrorBuilder() {
        }

        @Generated
        public ErrorBuilder status(final int status) {
            this.status = status;
            return this;
        }

        @Generated
        public ErrorBuilder timestamp(final Date timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        @Generated
        public ErrorBuilder message(final String message) {
            this.message = message;
            return this;
        }

        @Generated
        public ErrorBuilder description(final String description) {
            this.description = description;
            return this;
        }

        @Generated
        public Error build() {
            return new Error(this.status, this.timestamp, this.message, this.description);
        }

        @Generated
        public String toString() {
            int var10000 = this.status;
            return "Error.ErrorBuilder(status=" + var10000 + ", timestamp=" + String.valueOf(this.timestamp) + ", message=" + this.message + ", description=" + this.description + ")";
        }
    }
}
