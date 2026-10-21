### Added
- Fire now applies a special heart type.
- Item Descriptions support.
- Tag translations for backported tags.
- Backported content from 26.4-snapshot-5.
  - Ice Bricks and Chiseled Ice blocks.
  - "What Goes Around Comes Around" advancement.
  - Ice now occasionally makes ambient sound when surrounded by Ice, with air above and water below.
  - Ice Caves can now contain Strongholds and Ruined Portals.

### Changed
- Frostbites follow the same underground spawning rules as Strays.
- Renamed the `spawns_strays_without_powder_snow` biome tag to `spawns_cold_variants_underground`.
- Ice Crevasses generate more often.
- Icicle and Ice Crystal moved next to Brittle Ice in the creative inventory.

### Fixed
- Burning potion recipes now work on 1.21.1-26.2.
- On 26.3 and above, potion recipes are now data generated.
- Minimum Fabric Loader version is now set correctly.
- On 26.3, projectiles shot by mobs can break Icicles again (unless `mob_griefing` is off).
- The bottom face of floor Icicles was rotated 180 degrees.
- Mushrooms now spread onto any block that can support them in the dark, matching 26.4.