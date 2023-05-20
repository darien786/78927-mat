package mx.uv.graphQL.Exceptions;

import java.util.List;

import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.stereotype.Component;

import graphql.ErrorClassification;
import graphql.GraphQLError;
import graphql.language.SourceLocation;
import graphql.schema.DataFetchingEnvironment;

@Component
public class GraphQLExcepcionHandler extends DataFetcherExceptionResolverAdapter{

    @Override
    protected GraphQLError resolveToSingleError(Throwable ex, DataFetchingEnvironment env) {
        // TODO Auto-generated method stub
        return new GraphQLError() {


            @Override
            public List<SourceLocation> getLocations() {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public String getMessage() {
                // TODO Auto-generated method stub
                return ex.getMessage();
            }

            @Override
            public ErrorClassification getErrorType() {
                // TODO Auto-generated method stub
                return null;
            }
        };
    }
}
