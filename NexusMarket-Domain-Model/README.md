# NexusMarket — Domain Model and 14 Services

Cumulative university project. This package preserves the original domain model and provides **14 service classes, 14 input interfaces, and 41 public service operations**, with output repository contracts and a standalone smoke test.

## Structure
- `src/main/java/com/nexusmarket/domain/model`: entities and controlled business behaviors
- `src/main/java/com/nexusmarket/domain/valueobject`: catalogs and value objects
- `src/main/java/com/nexusmarket/domain/services`: 14 concrete service implementations
- `src/main/java/com/nexusmarket/domain/ports/in`: 14 interfaces implemented by services
- `src/main/java/com/nexusmarket/domain/ports/out`: repository and uniqueness contracts
- `docs/services.md`: implemented-operation count
- `docs/service-rules.md`: validations, limitations, pending decisions
- `docs/learning-guide-es.md`: explanation in Spanish
- `tests/DomainSmokeTest.java`: basic independent domain test

## Verify with PowerShell (JDK 17+)
```powershell
New-Item -ItemType Directory -Force build/classes | Out-Null
$files = Get-ChildItem src/main/java,tests -Recurse -Filter *.java | ForEach-Object FullName
javac -d build/classes $files
java -cp build/classes DomainSmokeTest
```

This is **not a complete Spring Boot application**. The interfaces have no production adapters yet. Do not claim that external payment verification, seller inventory ownership, multi-warehouse shipping, atomic transactions, or all candidate operations are implemented. See `docs/service-rules.md`.

## Existing GitHub repository
Copy the ZIP contents into the existing repository root, preserving `.git`. Review changes with `git diff` and `git status`, run tests, then commit and push.
