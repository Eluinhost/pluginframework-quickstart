#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service;

public class DefaultExampleService implements ExampleService
{
    public String getExampleValue()
    {
        return "Example Command";
    }
}
