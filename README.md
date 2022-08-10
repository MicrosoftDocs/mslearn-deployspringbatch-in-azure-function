# Deploy Spring Boot Batch Application on Azure Function using Spring Cloud Function

Spring Cloud Function enables Spring boot features on serverless providers, and includes adapters for Azure Functions. It provides out of the box mechanism to create a link between Spring Cloud Function and Azure Functions.

This quickstart shows you how to deploy Spring Boot Batch application on Azure Function. When you're finished, you can continue to manage the application via the Azure CLI or switch to using the Azure Portal.

* [Deploy Spring Boot apps using Azure Spring Cloud and MySQL](https://github.com/shrivastavarashmi/SampleSpringBatchTimerTrigger#deploy-spring-boot-batch-application-on-azure-function-using-spring-cloud-function)
  * [What will you experience](https://github.com/shrivastavarashmi/SampleSpringBatchTimerTrigger#what-will-you-experience)
  * [What you will need](https://github.com/shrivastavarashmi/SampleSpringBatchTimerTrigger#what-will-you-need)
  * [Clone and build the repo](https://github.com/shrivastavarashmi/SampleSpringBatchTimerTrigger#clone-and-build-the-repo)
  * [Run the application](https://github.com/shrivastavarashmi/SampleSpringBatchTimerTrigger#to-run-the-project-on-azure-cloud-shell)
  * [Deploy the application](https://github.com/shrivastavarashmi/SampleSpringBatchTimerTrigger#deploy-the-application-to-azure-functions)
  * [Verify and monitor the application](https://github.com/shrivastavarashmi/SampleSpringBatchTimerTrigger#verify-azure-function)

# What will you experience
You will:

* Build existing Spring Boot Batch application.This repository consists of sample application to showcase a way to deploy Spring Boot Batch application on Azure Function invoked by timer trigger.
* Run the application on Azure Cloud to check the functionality
* Provision Function App Instance
* Deploy the application to Azure Function App
* Verify and monitor the application

# What you will need

In order to deploy a Java app to cloud, you need an Azure subscription. If you do not already have an Azure subscription, you can activate your [MSDN subscriber benefits](https://azure.microsoft.com/en-us/pricing/member-offers/credit-for-visual-studio-subscribers/) or sign up for a free Azure account.

In addition, you will need the following:

| [Azure CLI version 2.17.1 or higher](https://docs.microsoft.com/en-us/cli/azure/install-azure-cli?view=azure-cli-latest) | [Java 11](https://docs.microsoft.com/en-us/azure/developer/java/fundamentals/java-support-on-azure) | [Maven](https://maven.apache.org/) | [Azure Functions Core Tools, version 3.0.13901.0 or above](https://docs.microsoft.com/en-us/azure/azure-functions/functions-run-local#v2) | [Azure SQL](https://docs.microsoft.com/en-us/azure/azure-sql/database/single-database-create-quickstart?tabs=azure-portal)

OR Use Azure Cloud Shell
Or, you can use the Azure Cloud Shell. Azure hosts Azure Cloud Shell, an interactive shell environment that you can use through your browser. You can use the Bash with Cloud Shell to work with Azure services. You can use the Cloud Shell pre-installed commands to run the code in this README without having to install anything on your local environment. To start Azure Cloud Shell: go to https://shell.azure.com, or select the Launch Cloud Shell button to open Cloud Shell in your browser.

To run the code in this article in Azure Cloud Shell:

Start Cloud Shell.

Select the Copy button on a code block to copy the code.

Paste the code into the Cloud Shell session by selecting Ctrl+Shift+V on Windows and Linux or by selecting Cmd+Shift+V on macOS.

Select Enter to run the code.

# Clone and build the repo

* Create a new folder and clone the sample app repository to your Azure Cloud account

  `mkdir source-code`  
  `git clone https://github.com/MicrosoftDocs/mslearn-springbootbatch-azurefunction.git`

* Change directory to the project

  `cd SampleSpringBatchTimerTrigger`

* Configure the project to use resource group and function app name as per your wish (it should be unique across Azure)

  * Open the ``` pom.xml file ```

  * Customize below properties
    * functionResourceGroup(you can use the same resource group name which you used to create Azure SQL)
    * functionAppName
    * functionAppRegion

* Configure Azure SQL Server details with Azure SQL Server details

  * Open the ``` application.properties ```
  * Customize the spring.datasource.url(jdbc url), spring.datasource.username and spring.datasource.password properties with already created Azure SQL server instance details.

* Change directory and build the project

  `cd SampleSpringBatchTimerTrigger`  
  `mvn clean package -DskipTests -Denv=cloud`

This will take a few minutes.

# Run the application

* Configure Storage account key with any of your Storage Account's connection string details

  * Open the ``` local.settings.json ```
  * Customize the AzureWebJobsStorage property with your storage account's connection string, the format should be like "DefaultEndpointsProtocol...."

* You would need to check exception in Azure SQL Server to allow Azure services and resources to access it. 

* Once the application is built again after these changes, you can use below command to run the project on Azure Cloud account:

  ``` mvn azure-functions:run ```

# Deploy the application to Azure Functions

Deploy the application to Azure Functions by using below command :

``` mvn azure-functions:deploy ```

This command will create new resource group (if not present already) as per given details in the properties setting of ```pom.xml```, also it will create function app, application service plan, application insight and storage account and then deploy the azure function into the Function App.

# Verify and monitor application
To verify if Azure function is working or not you can check below :
* Azure function gives facility to monitor your function for each successful or failure calls from your application, you can verify it easily and in case of any failure you can check the logs. Below are the checks you can do inside your function :
  ## Overview :

  ![image](https://user-images.githubusercontent.com/83832052/164419782-2b3bab39-cc12-4e4a-8bc2-68045f70c0dc.png)
  ## Monitor logs :

  ![image](https://user-images.githubusercontent.com/83832052/164419982-2af24cb9-cdbb-425e-8ce2-ea15b1730daf.png)
  ## Errors :

  ![image](https://user-images.githubusercontent.com/83832052/164420234-c854be27-b5a4-423f-8992-9e926824351a.png)
* Check Azure SQL database (_for data inserted from ```sample-data.csv``` file to the ```people``` table_ ) as below :

  ![image](https://user-images.githubusercontent.com/83832052/164417922-dff1bb91-97ee-45f2-bb00-00a8ef7e4ab6.png)
* Check Application insight (_for the logs and application map to see the call to Azure Functions_ ) as below :

  ![image](https://user-images.githubusercontent.com/83832052/164418988-5739c315-0084-4f96-a4c0-5b6517da775d.png)

  ![image](https://user-images.githubusercontent.com/83832052/164419111-159365d2-0e23-4dfb-8e76-6f9104edabd0.png)

# Reference Links
* [Create Azure Function using Intellij](https://docs.microsoft.com/en-us/azure/azure-functions/functions-create-maven-intellij)
* [Getting Started with Spring Cloud Function in Azure](https://docs.microsoft.com/en-us/azure/developer/java/spring-framework/getting-started-with-spring-cloud-function-in-azure)


# Contributing

This project welcomes contributions and suggestions.  Most contributions require you to agree to a
Contributor License Agreement (CLA) declaring that you have the right to, and actually do, grant us
the rights to use your contribution. For details, visit https://cla.opensource.microsoft.com.

When you submit a pull request, a CLA bot will automatically determine whether you need to provide
a CLA and decorate the PR appropriately (e.g., status check, comment). Simply follow the instructions
provided by the bot. You will only need to do this once across all repos using our CLA.

This project has adopted the [Microsoft Open Source Code of Conduct](https://opensource.microsoft.com/codeofconduct/).
For more information see the [Code of Conduct FAQ](https://opensource.microsoft.com/codeofconduct/faq/) or
contact [opencode@microsoft.com](mailto:opencode@microsoft.com) with any additional questions or comments.

# Legal Notices

Microsoft and any contributors grant you a license to the Microsoft documentation and other content
in this repository under the [Creative Commons Attribution 4.0 International Public License](https://creativecommons.org/licenses/by/4.0/legalcode),
see the [LICENSE](LICENSE) file, and grant you a license to any code in the repository under the [MIT License](https://opensource.org/licenses/MIT), see the
[LICENSE-CODE](LICENSE-CODE) file.

Microsoft, Windows, Microsoft Azure and/or other Microsoft products and services referenced in the documentation
may be either trademarks or registered trademarks of Microsoft in the United States and/or other countries.
The licenses for this project do not grant you rights to use any Microsoft names, logos, or trademarks.
Microsoft's general trademark guidelines can be found at http://go.microsoft.com/fwlink/?LinkID=254653.

Privacy information can be found at https://privacy.microsoft.com/en-us/

Microsoft and any contributors reserve all other rights, whether under their respective copyrights, patents,
or trademarks, whether by implication, estoppel or otherwise.
