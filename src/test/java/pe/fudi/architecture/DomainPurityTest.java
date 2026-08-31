package pe.fudi.architecture;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

@AnalyzeClasses(
        packages = "pe.fudi",
        importOptions = ImportOption.DoNotIncludeTests.class
)

class DomainPurityTest {

    @ArchTest
    static final ArchRule domainMustNotDependOnFrameworks =
            noClasses()
                    .that().resideInAPackage("..domain..")
                    .should().dependOnClassesThat()
                    .resideInAnyPackage(
                            "jakarta.persistence..",
                            "io.quarkus..",
                            "jakarta.ws.rs.."
                    )
                    .because("Domain classes must be expressible without any framework dependencies");

    @ArchTest
    static final ArchRule domainMustNotBeDependantOnInfrastructure =
            noClasses()
                    .that().resideInAPackage("..domain..")
                    .should().dependOnClassesThat()
                    .resideInAPackage("..infrastructure..")
                    .because("Dependency arrows point inwards, not outwards.");
}
