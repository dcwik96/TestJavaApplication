public class BrowserSelector {
    public static void setBrowserProperty(String browser) {
        if (System.getProperty("os.name").contains("Windows")) {
            switch (browser) {
                case "Chrome":
                    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                    break;
                case "Firefox":
                    System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
                    break;
                case "Explorer":
                    System.setProperty("webdriver.ie.driver", "src/main/resources/IEDriverServer.exe");
                    break;
                case "Opera":
                    System.setProperty("webdriver.opera.driver", "src/main/resources/operadriver.exe");
                    break;
                case "Phantom":
                    System.setProperty("phantomjs.binary.path", "src/main/resources/phantomjs.exe");
                    break;
            }
        } else {
            switch (browser) {
                case "Chrome":
                    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
                    break;
                case "Firefox":
                    System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
                    break;
                case "Explorer":
                    throw new IllegalArgumentException("Explorer browser is accesed only on Windows");
                case "Opera":
                    System.setProperty("webdriver.opera.driver", "src/main/resources/operadriver");
                    break;
                case "Phantom":
                    System.setProperty("phantomjs.binary.path", "src/main/resources/phantomjs");
                    break;
            }
        }
    }
}
