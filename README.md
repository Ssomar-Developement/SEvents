# SEvents

A comprehensive Minecraft Bukkit/Spigot plugin library that provides advanced event handling and custom event registration for enhanced gameplay mechanics.

## Overview

SEvents is a powerful Java library designed for Minecraft server plugins that extends the standard Bukkit/Spigot event system with custom events and specialized listeners. It provides developers with a robust framework for handling complex player interactions, entity behaviors, and server mechanics.

### Key Features

- **Custom Event System**: Extended event framework built on top of Bukkit's event system
- **Player Interaction Events**: Comprehensive left/right click handling for blocks, entities, and players
- **Combat Events**: Advanced player vs player and player vs entity combat detection
- **Movement Events**: Detailed tracking of player movement states (jump, sprint, swim, fly, glide, sneak)
- **Equipment Events**: Armor equipping/unequipping detection
- **Fishing Events**: Specialized fishing mechanics with different catch types
- **Projectile Events**: Enhanced projectile impact detection
- **Block Events**: Advanced block interaction and manipulation events
- **Death Events**: Pre-death event handling for players and entities
- **Participation System**: Track entity participation in kills and combat

## Requirements

- **Java Version**: 8 or higher
- **Minecraft Version**: Compatible with Spigot/Bukkit 1.21.3
- **Dependencies**: Spigot API 1.21.3-R0.1-SNAPSHOT

## Installation

### For Developers

Add SEvents as a dependency to your project:

#### Maven
```xml
<repositories>
    <repository>
        <id>jitpack</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependency>
    <groupId>com.github.ssomar</groupId>
    <artifactId>SEvents</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

#### Gradle
```gradle
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.ssomar:SEvents:1.0-SNAPSHOT'
}
```

### For Plugin Users

This is a library dependency that other plugins use. You typically don't need to install this directly unless specifically required by another plugin.

## Building from Source

### Prerequisites

- Java 8 or higher
- Maven 3.6 or higher
- Git

### Build Steps

1. Clone the repository:
   ```bash
   git clone https://github.com/ssomar/SEvents.git
   cd SEvents
   ```

2. Build the project:
   ```bash
   mvn clean install
   ```

3. The compiled JAR will be available in the `target/` directory.

## Usage

### Basic Event Registration

```java
import com.ssomar.sevents.SEventFactory;
import com.ssomar.sevents.events.player.click.left.PlayerLeftClickEvent;

// Register custom events
SEventFactory.registerEvent(new PlayerLeftClickEvent());
```

### Event Handling Example

```java
@EventHandler
public void onPlayerLeftClick(PlayerLeftClickEvent event) {
    Player player = event.getPlayer();
    // Handle left click logic
}
```

### Available Event Categories

- **Player Events**: Click interactions, movement, combat, equipment
- **Entity Events**: Before death, combat participation
- **Block Events**: Drying, trampling, interactions
- **Projectile Events**: Impact detection with blocks, entities, players
- **Fishing Events**: Catch different types (fish, entity, player, nothing)

## Contributing

We welcome contributions to SEvents! Please follow these guidelines:

### How to Contribute

1. **Fork the Repository**
   ```bash
   git fork https://github.com/ssomar/SEvents.git
   ```

2. **Create a Feature Branch**
   ```bash
   git checkout -b feature/your-feature-name
   ```

3. **Make Your Changes**
   - Follow the existing code style and patterns
   - Add appropriate documentation
   - Include tests if applicable

4. **Commit Your Changes**
   ```bash
   git commit -m "Add: Brief description of your changes"
   ```

5. **Push to Your Fork**
   ```bash
   git push origin feature/your-feature-name
   ```

6. **Create a Pull Request**
   - Provide a clear description of your changes
   - Reference any related issues
   - Include testing information

### Code Style Guidelines

- Use consistent indentation (spaces preferred)
- Follow Java naming conventions
- Add JavaDoc comments for public methods
- Keep methods focused and concise
- Use meaningful variable and method names

### Reporting Issues

Please use the GitHub Issues tracker to report:
- Bugs and unexpected behavior
- Feature requests
- Documentation improvements
- Performance issues

When reporting issues, include:
- Minecraft/Spigot version
- Java version
- Steps to reproduce
- Expected vs actual behavior
- Any error messages or logs

## Development

### Project Structure

```
src/main/java/com/ssomar/sevents/
├── EventName.java              # Event name enumeration
├── SEvent.java                 # Base event class
├── SEventFactory.java          # Event factory and registration
├── events/                     # Event implementations
│   ├── block/                  # Block-related events
│   ├── entity/                 # Entity-related events
│   ├── player/                 # Player-related events
│   └── projectile/             # Projectile-related events
├── registration/               # Event registration system
└── version/                    # Version management
```

### Testing

Run tests with:
```bash
mvn test
```

### Version Management

The project uses semantic versioning (MAJOR.MINOR.PATCH):
- **MAJOR**: Breaking changes
- **MINOR**: New features, backward compatible
- **PATCH**: Bug fixes, backward compatible

## License

This project is licensed under the Ssomar Custom License - see the [LICENSE](LICENSE) file for details.

**Key License Terms:**
- ✅ Personal use, modification, and non-commercial distribution allowed
- ❌ Commercial redistribution prohibited
- ❌ Selling or including in paid products not allowed
- 📞 Contact Ssomar for commercial licensing

## Support

- **Issues**: [GitHub Issues](https://github.com/ssomar/SEvents/issues)
- **Documentation**: This README and inline code documentation
- **Community**: Join the discussion in GitHub Discussions

## Changelog

### Version 1.0-SNAPSHOT
- Initial release with core event system
- Player interaction events
- Combat and movement tracking
- Equipment and fishing events
- Projectile impact detection

---

**Note**: This library is designed for Minecraft plugin developers. End users typically don't need to interact with this directly unless building custom plugins.