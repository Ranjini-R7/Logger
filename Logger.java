   // Log the action: method execution
        logger.logInfo("Executing method: " + method.getName());

        // Pause if needed
        Thread.sleep(ConfigurationManager.configuration().pauseLow());

        // Conditional logic to skip certain methods for screenshots
        if (method.getName().equalsIgnoreCase("quit") || 
            method.getName().equalsIgnoreCase("close")) {
            logger.logInfo("Skipping screenshot for method: " + method.getName());
        } else {
            takeScreenshot();  // Capture screenshot
            logger.logInfo("Screenshot taken for method: " + method.getName());
        }
    } catch (Exception e) {
        // Log the exception with its name and message
        logger.logError("Exception in afterAnyCall for method: " + method.getName() +
                        " | Exception Type: " + e.getClass().getSimpleName() + 
                        " | Message: " + e.getMessage(), e);
    }