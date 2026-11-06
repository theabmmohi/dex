# Samsung DeX Settings Launcher

A small Android utility that opens the Samsung DeX settings screen directly, for Samsung devices where the option is hidden, restricted or missing from the stock Settings menu.

## Features

* **Direct access:** Jumps straight to the DeX settings screen, with no menu hunting.
* **Fallback:** If the DeX screen isn't available on the device, it opens the regular Settings app instead.
* **Lightweight:** No UI, no background services, no network access, and no permissions requested.
* **No root required:** Works on standard devices.

## Installation

1. Open the [Releases](../../releases) page of this repository.
2. Download the latest `dex-vX.Y.Z.apk`, and the matching `.sha256` file if you want to verify it.
3. Open the APK on your device and install it. Android will ask you to allow installs from unknown sources the first time.
4. Launch the app. It opens the DeX settings and closes itself.

Requires Android 8.0 (API 26) or newer.

## Verify your download

Every release is built by GitHub Actions from the tagged commit, signed with the project's release key, and published with a build provenance attestation. You can check all three. Replace `vX.Y.Z` with the version you downloaded.

**1. Checksum.** Confirms the file wasn't corrupted or swapped after publishing. Run it in the folder containing both files:

```
sha256sum -c dex-vX.Y.Z.apk.sha256
```

**2. Build provenance.** Confirms the file was built by this repository's release workflow from a specific commit. Needs the [GitHub CLI](https://cli.github.com/):

```
gh attestation verify dex-vX.Y.Z.apk --repo theabmmohi/dex
```

The output names the repository, the workflow file and the commit the APK came from. If it fails, don't install the file.

**3. Signing certificate.** Confirms the APK is signed by the same key as every other release. Uses `apksigner` from the Android SDK build-tools:

```
apksigner verify --print-certs dex-vX.Y.Z.apk
```

The certificate SHA-256 digest should be:

```
b1e41760c8346f6c93f8ebc0ffe9a4709d5c27f19fd75bb5ddb68a0019156d4b
```

An APK signed with any other key is not an official release, and Android will refuse to install it as an update over an official one.

## Why is this needed?

On some Samsung devices, certain carrier or regional software builds hide the Samsung DeX entry from the Settings menu even though the system supports it. This app is a direct shortcut to that hidden screen. It targets Samsung's `com.android.settings` DeX activity, so on non-Samsung phones it will only open the regular Settings app.

## Building from source

You need JDK 21 or newer and the Android SDK (platform 37).

```
git clone https://github.com/theabmmohi/dex.git
cd dex
./gradlew assembleDebug
```

The debug APK is written to `app/build/outputs/apk/debug/`. Release builds are signed with a private key that is not in this repository, so a build you make yourself will have a different signature from the official releases.

## License

See [LICENSE](LICENSE).

---

*Disclaimer: This application is an independent utility and is not officially affiliated with or endorsed by Samsung Electronics.*